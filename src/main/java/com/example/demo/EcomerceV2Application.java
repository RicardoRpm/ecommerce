package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class EcomerceV2Application {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceV2Application.class, args);
              
	}

}
