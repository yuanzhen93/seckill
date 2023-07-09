package com.gupao.seckill.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.Format;
import java.time.Instant;
import java.util.Date;

@Data
public class SeckillDtail {

    @Id
    @GeneratedValue
    private long id;

    private String activityname;

    private BigDecimal price;

    private long commodityId;

    private int stock;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;


}
