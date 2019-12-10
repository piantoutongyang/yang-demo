package com.mingyisoft.demo.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    RedisTemplate redisTemplate;
    static RedisTemplate staticTemplate;

    private RedisUtil(){

    }

    @PostConstruct
    public void init () throws Exception{
        staticTemplate = redisTemplate;
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     */
    public static void set(String key,Object value){
        set(key, value, null);
    }

    /**
     * 设置缓存
     * @param key
     * @param value
     * @param time 单位毫秒
     */
    public static void set(String key,Object value,Integer time){
        if(time!=null){
            staticTemplate.opsForValue().set(key, value, time , TimeUnit.MILLISECONDS);
        } else {
            staticTemplate.opsForValue().set(key, value, time);
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public static Object get(String key){
        return staticTemplate.opsForValue().get(key);
    }
}
