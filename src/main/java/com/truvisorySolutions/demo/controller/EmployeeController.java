package com.truvisorySolutions.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truvisorySolutions.demo.entity.Employee;
import com.truvisorySolutions.demo.service.EmployeeService;

@RestController

@RequestMapping("/emp")

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee employee) {
		return employeeService.saveEmp(employee);
	}
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee employee) {
		return employeeService.updateEmp(employee);
	}
	@GetMapping("/get/{empId}")
	public Employee getEmp(@PathVariable Integer empId) {
		return employeeService.getEmp(empId);
	}
	@DeleteMapping("/delete/{empId}")
	public String deleteEmp(@PathVariable Integer empId) {
		return employeeService.deleteEmp(empId);
	}
	@GetMapping("/all")
	public List<Employee>allEmps(){
		return employeeService.allEmps();
	}
	
	

}
