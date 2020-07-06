package com.redis.web.controller;

import com.redis.domain.Hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * com.redis.web
 * Created by mimiczo on 2016.03.03
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    RedisTemplate<String, Hello> redisTemplate;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public Hello get(@PathVariable("key") String key) {
        Hello hello = redisTemplate.opsForValue().get("hello:"+key);
        log.debug("{}", hello);
        return hello;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Hello hello) {
        redisTemplate.opsForValue().set("hello:"+hello.getName(), hello);
    }
}