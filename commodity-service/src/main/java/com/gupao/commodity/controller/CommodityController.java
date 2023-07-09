package com.gupao.commodity.controller;

import com.gupao.commodity.model.CommodityInfo;
import com.gupao.user.starter.annotation.LoginUserId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class CommodityController {

    @GetMapping("/commodities/{id}")
    public CommodityInfo getById(@PathVariable("id")long id, @LoginUserId long userId) {
        log.info("get user id:{}", userId);
        return CommodityInfo.builder().id(1).name("iphone xxx").desc("iphone xxx").build();
    }


}
