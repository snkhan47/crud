package com.nihal.service;

import java.util.List;

import com.nihal.modal.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> fetchEmployeeList();

	Employee updateEmployee(Employee employee, Long employeeId);

	void deleteEmployeeById(Long departmentId);

	Employee getEmployeeById(Long employeeId);

}
