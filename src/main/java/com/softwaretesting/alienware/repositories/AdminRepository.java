package com.softwaretesting.alienware.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import com.softwaretesting.alienware.models.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
//    Optional<Admin> FindByUsername(String s);

}
