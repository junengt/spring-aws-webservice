package com.example.springawswebservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@AutoConfigureMockMvc
@SpringBootTest
class HelloControllerTest {

    @Autowired // 스프링이 관리하는 bean 주입
    private MockMvc mockMvc;

    //String 리턴
    @Test
    public void hello_리턴() throws Exception {
        String hello = "hello";

        mockMvc.perform(get("/hello")) // /hello 주소로 GET 요청

                //mockMvc.perform 결과 검증
                .andExpect(status().isOk()) //Header 상태 코드 검증
                .andExpect(content().string(hello)); //응답 본문 내용 검증
    }

    //Json 리턴
    @Test
    public void helloDto_리턴() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get("/hello/dto")
                        .param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}