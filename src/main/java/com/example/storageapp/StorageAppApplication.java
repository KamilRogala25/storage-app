package com.example.storageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class StorageAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageAppApplication.class, args);
	}

}
