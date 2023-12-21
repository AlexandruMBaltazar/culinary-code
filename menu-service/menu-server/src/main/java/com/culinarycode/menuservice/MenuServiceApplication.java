package com.culinarycode.menuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.culinarycode.menuservice",
											"com.culinarycode.menuservice.client",
											"com.culinarycode.commonservice" })
public class MenuServiceApplication {

	public static void main( String[] args ) {
		SpringApplication.run( MenuServiceApplication.class, args );
	}

}
