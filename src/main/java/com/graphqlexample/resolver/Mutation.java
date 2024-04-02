package com.graphqlexample.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.graphqlexample.repository.EmployeeRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

}
