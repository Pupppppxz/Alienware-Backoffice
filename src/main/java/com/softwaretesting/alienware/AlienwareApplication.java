package com.softwaretesting.alienware;


import jakarta.persistence.spi.PersistenceProvider;
import com.softwaretesting.alienware.configs.RsaKeyProperties;
import com.softwaretesting.alienware.models.Admin;
import com.softwaretesting.alienware.repositories.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class AlienwareApplication  {

	public static void main(String[] args) {
		System.out.println("test test test");
		SpringApplication.run(AlienwareApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(AdminRepository users){
//		return args -> {
//			users.save(new Admin("test@gmail.com","password"));
//
//		};
//	}




}
