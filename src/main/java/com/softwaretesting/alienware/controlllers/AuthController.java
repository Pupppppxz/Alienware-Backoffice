package com.softwaretesting.alienware.controlllers;
import com.softwaretesting.alienware.models.LoginRequest;
import com.softwaretesting.alienware.models.ResToken;
import com.softwaretesting.alienware.services.Tokenservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final Tokenservice tokenservice;
    private final AuthenticationManager authenticationManager;
    public AuthController(Tokenservice tokenservice, AuthenticationManager authenticationManager) {
        this.tokenservice = tokenservice;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public ResToken token(@RequestBody LoginRequest userlogin){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userlogin.username(),userlogin.password()));
//        return tokenservice.generateToken(authentication);
        String token = tokenservice.generateToken(authentication);
        return new ResToken(token,new Date());
    }
}
