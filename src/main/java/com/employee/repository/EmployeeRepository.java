package com.employee.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	Optional<Employee> findByEmailAndPassword(String email,String password);
	
	Optional<Employee> findByNameAndAddress(String name, String address);
}
