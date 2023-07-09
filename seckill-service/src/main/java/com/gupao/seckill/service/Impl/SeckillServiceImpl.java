package com.gupao.seckill.service.Impl;

import com.gupao.seckill.service.ISeckillService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;

import java.util.Arrays;
@Slf4j
public class SeckillServiceImpl implements ISeckillService {

    private RedissonClient redissonClient;
    private RocketMQTemplate rocketMQTemplate;

    private String getStockKey(long activityId) {
        return String.format("activity:%s:stock", activityId);
    }

    private String getUserSetKey(long activityId) {
        return String.format("activity:%s:user:set", activityId);
    }

    @Override
    public boolean buy(long activityId, long userId) {

        String script = "if redis.call('exists',KEYS[1]) == 1 then\n" +
                "                 local stock = tonumber(redis.call('get', KEYS[1]))\n" +
                "                 if( stock <=0 ) then\n" +
                "                    return -1\n" +
                "                 end;\n" +
                "                 if redis.call('SISMEMBER',KEYS[2],ARGV[1]) == 1 then" +
                "                    return -2\n" +
                "                 end;\n" +
                "                 redis.call('SADD',KEYS[2],ARGV[1]);\n" +
                "                 redis.call('decr',KEYS[1]);\n" +
                "                 return stock - 1;\n" +
                "             end;\n" +
                "             return -1;";
        int cnt = redissonClient.getScript().eval(RScript.Mode.READ_WRITE, script, RScript.ReturnType.INTEGER,
                Arrays.asList(getStockKey(activityId), getUserSetKey(activityId)), Arrays.asList(userId));
        if (cnt >= 0) {
            //异步下单
        }
        return false;
    }
}
