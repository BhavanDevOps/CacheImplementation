package com.truvisorySolutions.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truvisorySolutions.demo.entity.Employee;
import com.truvisorySolutions.demo.repository.EmployeeRepository;

/*import lombok.AllArgsConstructor;*/


@Service

public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee saveEmp(Employee employee) {
		return employeeRepository.save(employee);
	}
	@CachePut(cacheNames = "employee" , key = "employee.empID")
	public Employee updateEmp(Employee employee) {
		System.out.println("Update API H2 Database Calling !.");
		return employeeRepository.save(employee);
	}
	
	@Cacheable(cacheNames = "employee",key = "#empId")
	public Employee getEmp(Integer empId) {
		System.out.println("Get API H2 Database Calling !.");
		return employeeRepository.findById(empId).get();
	}
	@CacheEvict(cacheNames="employee",key = "#empId")
	public String deleteEmp(Integer empId) {
		System.out.println("Delete API H2 Database Calling !.");
		employeeRepository.deleteById(empId);
		return "Employee Deleted Successfully";
	}

	public List<Employee> allEmps() {
		return employeeRepository.findAll();
	}
}
