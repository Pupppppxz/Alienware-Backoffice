package com.softwaretesting.alienware.controllers;

import com.softwaretesting.alienware.models.LoginRequest;
import com.softwaretesting.alienware.models.ResToken;
import com.softwaretesting.alienware.services.Tokenservice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.util.ObjectUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private Tokenservice tokenservice;

    @Test
    void should_return_token_when_call_generateToken_given_valid_user_and_password(){
        //Given
        LoginRequest body = new LoginRequest("Admin","Admin12345");

        //When
        when(tokenservice.generateToken(any())).thenReturn("token");
        ResToken actual = authController.token(body);
        //then
        assertEquals("token",actual.token());
    }

    @Test
    void should_return_token_when_call_generateToken_given_invalid_user_and_password(){
        //Given
        LoginRequest body = new LoginRequest("Admin1231232","Admin1232131245");

        //When
        when(tokenservice.generateToken(any())).thenReturn(null);
        ResToken actual = authController.token(body);
        //then
        assertEquals(null,actual.token());
    }

//    @Test
//    void should_return_token_when_call_generateToken_given_valid_user_and_password(){
//        //Given
//        LoginRequest body = new LoginRequest("Admin1","Admin12345");
//        when(tokenservice.generateToken(any())).thenReturn("token");
//
//        //When
//        String actual = authController.token(body);
//
//        //then
//        assertEquals("token", actual);
//    }
}