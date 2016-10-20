package com.arksh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by qq on 2016/10/21.
 */
public class LogicService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String createId(Object t) {
        String redisKey = "REDIS_TBL_" + t.getClass().getSimpleName();
        String dateTime = DateUtil.getDateTime(DATE_PATTERN.YYYYMMDDHHMMSSSSS);
        ValueOperations<String, Object> valueOper = stringRedisTemplate.opsForValue();
        valueOper.increment(key,1);
        Object value=valueOper.get(key);
        return dateTime + stringRedisTemplate.opsForValue();
    }
}
