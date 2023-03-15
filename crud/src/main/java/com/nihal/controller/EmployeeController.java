package com.nihal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nihal.modal.Employee;
import com.nihal.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public Employee saveEmployees(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	// Read operation
	@GetMapping("/all")
	public List<Employee> fetchEmployeeList() {
		return employeeService.fetchEmployeeList();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
		 Employee epmloyee = employeeService.getEmployeeById(employeeId);
		 return new ResponseEntity<>(epmloyee, HttpStatus.OK);
	}

	// Update operation
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
		return employeeService.updateEmployee(employee, employeeId);
	}

	// Delete operation
	@DeleteMapping("/delete/{id}")

	public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return "Deleted Successfully";
	}
}
