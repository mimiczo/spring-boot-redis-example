package com.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * com.redis.domain
 * Created by mimiczo on 2016.03.03
 */
@Data
@AllArgsConstructor
public class Hello implements Serializable {

    private String name;
    private String message;

    public Hello() {}
}
