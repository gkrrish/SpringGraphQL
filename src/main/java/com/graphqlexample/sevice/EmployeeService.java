package com.graphqlexample.sevice;

import java.util.ArrayList;
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

	public Iterable<Employee> getAllEmployees() {
		List<Employee> testEmployee=new ArrayList<>();
		testEmployee.add(new Employee(100l, "someName", 12, "CSE"));
		return testEmployee;
	}

	public Employee getEmployeeById(Long id) {
		Employee testEmployee=new Employee();
		testEmployee.setAge(12);
		testEmployee.setDepartment("ECE");
		testEmployee.setId(10L);
		testEmployee.setName("Krishna");
		if(id==10) {
			return testEmployee;
		}
		return new Employee(13L, "DummyName", 13, "Mechanical");
	}
}
