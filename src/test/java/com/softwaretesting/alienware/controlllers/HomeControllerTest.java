package com.softwaretesting.alienware.controlllers;

import com.softwaretesting.alienware.configs.SecurityConfig;
import com.softwaretesting.alienware.services.Tokenservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({HomeController.class,AuthController.class})
@Import({SecurityConfig.class, Tokenservice.class})
class HomeControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void  return_isUnauthorized_when_req_whit_out_user_password() throws  Exception{
        this.mvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }


}