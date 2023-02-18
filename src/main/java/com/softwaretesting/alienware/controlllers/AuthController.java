package com.softwaretesting.alienware.controlllers;
import com.softwaretesting.alienware.services.AuthService;

public class AuthController {

    private AuthService authservice;

    public String login(String user,String pass){
        if(authservice.compare(user,pass)){
            return "success";
        }
        else{
            return "fail";
        }
        
    }
}
