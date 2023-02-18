package com.softwaretesting.alienware.controlllers;
import com.softwaretesting.alienware.services.AuthService;

public class AuthController {

    private AuthService authservice;

    public String login(String user,String pass){
        if(user==authservice.getUser() &&pass==authservice.getPassword()){
            return "success";
        }
        else{
            return "fail";
        }
        
    }
}
