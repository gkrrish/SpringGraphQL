package com.graphqlexample.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphqlexample.entity.Employee;
import com.graphqlexample.repository.EmployeeRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	@Autowired
	private EmployeeRepository employeeRepository;

	public String hello() {
		return "Hello, GraphQL!";
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

}
