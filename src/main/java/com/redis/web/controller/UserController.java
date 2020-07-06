package com.redis.web.controller;

import com.redis.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * com.redis.web.controller
 * Created by mimiczo on 2016.03.04
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    RedisTemplate<String, User> redisTemplate;

    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public User get(@PathVariable("key") String key) {
        User user = redisTemplate.opsForValue().get("user:"+key);
        log.debug("{}", user);
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user) {
        redisTemplate.opsForValue().set("user:"+user.getId(), user);
    }
}
