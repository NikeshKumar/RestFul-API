package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.demo")
public class MyComtactsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyComtactsApplication.class, args);
	}
	
}
