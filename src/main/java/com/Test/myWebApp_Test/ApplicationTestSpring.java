package com.Test.myWebApp_Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApplicationTestSpring extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTestSpring.class, args);
	}
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(ApplicationTestSpring.class);
	  }
}
