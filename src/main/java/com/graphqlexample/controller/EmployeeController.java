package com.graphqlexample.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphqlexample.entity.Employee;
import com.graphqlexample.sevice.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@QueryMapping
	public String hello() {
		return "Hello GraphQL!";
	}

	public Iterable<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	public Employee getEmployeeById(Long id) {
		return employeeService.getEmployeeById(id);
	}

	@QueryMapping()
	public List<Employee> getEmployees() {
		return employeeService.getEmployees().orElse(Collections.emptyList());
	}

	@QueryMapping
//	@SchemaMapping(typeName = "Query", field = "getEmployee")//we can write in schema style also
	public Employee getEmployee(Long id) {
		return employeeService.findById(id).orElse(Employee.emptyEmployee());// orElse(null);
	}

	@SchemaMapping(typeName = "Mutation", field = "addEmployee")
//	@MutationMapping//this aslo we can write
	public String addEmployee(Employee employee) {
		return employeeService.addEmployee(employee);
	}

//	@SubscriptionMapping//this is also there
}
