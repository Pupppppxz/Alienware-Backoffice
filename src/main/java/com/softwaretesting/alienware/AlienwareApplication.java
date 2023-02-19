package com.softwaretesting.alienware;

import jakarta.persistence.spi.PersistenceProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlienwareApplication  {

	public static void main(String[] args) {
		System.out.println("test test test");
		SpringApplication.run(AlienwareApplication.class, args);
	}



}
