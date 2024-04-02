package com.graphqlexample.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.graphqlexample.entity.Employee;
import com.graphqlexample.repository.EmployeeRepository;

import graphql.kickstart.tools.GraphQLResolver;

public class FieldResolver implements GraphQLResolver<Employee> {

	@Autowired
	private EmployeeRepository employeeRepository;

}
