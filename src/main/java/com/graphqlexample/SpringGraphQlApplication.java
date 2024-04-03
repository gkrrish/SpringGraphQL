package com.graphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.graphqlexample", "com.graphqlexample.component", "com.graphqlexample.repository"})
public class SpringGraphQlApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlApplication.class, args);
	}

}
