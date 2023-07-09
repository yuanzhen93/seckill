package com.gupao.seckill.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class SeckillDetailDTO {
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
