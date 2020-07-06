package com.redis.web.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.domain.Hello;
import com.redis.web.MockMvcTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * com.redis.web.mvc
 * Created by mimiczo on 2016.03.04
 */
@Slf4j
public class HelloControllerTest extends MockMvcTest{

    @Test
    public void 등록() throws Exception {
        //given
        String name = "mimiczo";
        String message = "hellworld redis-example";
        Hello hello = new Hello(name, message);

        String content = new ObjectMapper().writeValueAsString(hello);
        log.debug("param json ==== {}", content);

        //when
        this.mockMvc
                .perform(post("/hello")
                        //example parameter setting
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .characterEncoding(CHARSET)
                )
        //then
        .andExpect(status().isCreated())
        .andReturn();
    }

    @Test
    public void 조회() throws Exception {
        //given
        String key = "mimiczo";

        //when
        this.mockMvc
                .perform(get("/hello/" + key)
                        .characterEncoding(CHARSET)
                )
        //then
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value(key))
        .andExpect(jsonPath("$.message").isNotEmpty())
        .andReturn();
    }
}