package com.one.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.one.shop"})
public class MyBatisApplication implements CommandLineRunner {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyBatisApplication.class, args);
	}


	@Override
	public void run(String... args) {
        System.out.println("system is running");
	}

}
