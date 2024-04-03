package com.graphqlexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqlexample.entity.Employee;
import com.graphqlexample.sevice.EmployeeService;

import graphql.GraphQLException;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@QueryMapping
	public String hello() {
		return "Hello GraphQL!";
	}

	@QueryMapping
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeService.getAllEmployees();
	}

	@QueryMapping
	public Employee getEmployeeById(@Argument("id") String id) {
		try {
			Long employeeIdLong = Long.parseLong(id);
			return employeeService.getEmployeeById(employeeIdLong); // Assuming this method returns Employee
		} catch (NumberFormatException e) {
			throw new GraphQLException("Invalid employee ID format");
		}
	}

	@QueryMapping
	public Employee getEmployee(Long id) {
		return employeeService.findById(id).orElse(null);
	}

	@SchemaMapping(typeName = "Mutation", field = "addEmployee")
	public String addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}

}
