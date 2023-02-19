package com.softwaretesting.alienware.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "admin")
public class Admin {
    @Id
    private String Email;
    private  String Password;
    private  Date LastLogin;
    private  Date CreateAt;
    private  Date UpdatedAt;

    public Admin(){}
    public Admin (String email,String password){
        this.Email = email;
        this.Password = password;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getLastLogin() {
        return LastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        LastLogin = lastLogin;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        UpdatedAt = updatedAt;
    }
}
