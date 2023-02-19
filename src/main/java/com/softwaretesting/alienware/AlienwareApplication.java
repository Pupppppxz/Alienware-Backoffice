package com.softwaretesting.alienware;


import com.softwaretesting.alienware.configs.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

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
