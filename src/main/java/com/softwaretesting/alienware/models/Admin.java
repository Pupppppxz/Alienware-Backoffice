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
}
