//package com.softwaretesting.alienware.services;
//
//
//import com.softwaretesting.alienware.models.SecurityUser;
//import com.softwaretesting.alienware.repositories.AdminRepository;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class JpaUserDetailsService implements UserDetailsService {
//
//    private final AdminRepository adminRepository;
//
//    public JpaUserDetailsService(AdminRepository adminRepository) {
//
//        this.adminRepository = adminRepository;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return adminRepository
//                .FindByUsername(username)
//                .map(SecurityUser::new)
//                .orElseThrow(()->new UsernameNotFoundException("Username not found "));
//    }
//}
