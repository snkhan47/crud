package com.nihal.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihal.exception.UserNotFoundException;
import com.nihal.modal.Employee;
import com.nihal.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo employeeRepo;
	

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> fetchEmployeeList() {
		
		return (List<Employee>)employeeRepo.findAll();
	}
	

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepo.findById(employeeId)
				.orElseThrow(() -> new UserNotFoundException("user by id " + employeeId + " was not found"));
	}
	
	@Override
	public Employee updateEmployee(Employee employee, Long employeeId) {
		{
			
			Employee empDB = employeeRepo.findById(employeeId).get();
	 
	        if (Objects.nonNull(employee.getFirstName()) && !employee.getFirstName().isEmpty()) {
	        	empDB.setFirstName(employee.getFirstName());
	        }
	 
	        if (Objects.nonNull(employee.getLastName())&& !employee.getLastName().isEmpty()) {
	        	empDB.setLastName(employee.getLastName());
	        }
	 
	        if (Objects.nonNull(employee.getEmail()) && !employee.getEmail().isEmpty()) {
	        	empDB.setEmail(employee.getEmail());
	        }
	        
	        if (Objects.nonNull(employee.getAge()) && employee.getAge()!=null) {
	        	empDB.setAge(employee.getAge());
	        }

	        return employeeRepo.save(empDB);
	    }
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		employeeRepo.deleteById(employeeId);
		
	}

}
