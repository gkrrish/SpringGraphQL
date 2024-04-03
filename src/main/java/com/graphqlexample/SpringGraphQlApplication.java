package com.graphqlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.graphqlexample"})
public class SpringGraphQlApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringGraphQlApplication.class, args);
		
		System.out.println("http://localhost:8286/graphiql?path=/graphql");
	}

}
