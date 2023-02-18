package com.softwaretesting.alienware.services;

public class AuthService {
    

    public boolean compare(String user,String pass){
        if(user=="Admin"&&pass=="Admin1234"){
            return true;
        }
        else{
            return false;
        }
    }
}
