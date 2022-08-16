package com.emp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.Model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
