package com.graphqlexample.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqlexample.entity.Employee;
import com.graphqlexample.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Optional<List<Employee>> getEmployees() {
		return Optional.ofNullable(employeeRepository.findAll());
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public String addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return (savedEmployee != null && savedEmployee.getId() != null)
				? "Employee added successfully with ID : " + savedEmployee.getId()
				: "employee not saved";
	}

}
