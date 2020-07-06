package com.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * com.redis.domain
 * Created by mimiczo on 2016.03.04
 */
@Data
@AllArgsConstructor
public class User implements Serializable {

    private String id;
    private String name;
}
