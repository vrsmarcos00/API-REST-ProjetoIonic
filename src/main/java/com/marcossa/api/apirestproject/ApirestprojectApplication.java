package com.marcossa.api.apirestproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcossa.api.apirestproject.service.S3Service;

@SpringBootApplication
public class ApirestprojectApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(ApirestprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\marcos\\Desktop\\Marcos Sá\\9810.jpg");
	}

}