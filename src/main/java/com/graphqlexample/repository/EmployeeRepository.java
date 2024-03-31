package com.graphqlexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphqlexample.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
