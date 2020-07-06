package com.redis.web.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.domain.User;
import com.redis.web.MockMvcTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * com.redis.web.mvc
 * Created by mimiczo on 2016.03.07
 */
@Slf4j
public class UserControllerTest extends MockMvcTest {

    @Test
    public void 등록() throws Exception {
        //given
        String id = "zhoon80@gmail.com";
        String name = "mimiczo";
        User user = new User(id, name);

        String content = new ObjectMapper().writeValueAsString(user);
        log.debug("param json ==== {}", content);

        //when
        this.mockMvc
                .perform(post("/user")
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
}
