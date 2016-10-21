package com.arksh.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by qq on 2016/10/21.
 */
@Service
public class LogicService {
    @Autowired
    RedisTemplate redisTemplate;

    public String createId(Object t) {
        String redisKey = "REDIS_TBL_" + t.getClass().getSimpleName();
        String dateTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
        valueOper.increment(redisKey,1);
        Object value = valueOper.get(redisKey);
        return dateTime + StringUtils.leftPad(value.toString(),10,"0")+ RandomStringUtils.randomNumeric(4);
    }
}
