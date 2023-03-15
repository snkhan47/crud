package com.nihal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nihal.modal.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long > {

}
