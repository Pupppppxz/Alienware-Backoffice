package com.softwaretesting.alienware.repositories;

import org.springframework.data.repository.CrudRepository;

import com.softwaretesting.alienware.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {
    
}
