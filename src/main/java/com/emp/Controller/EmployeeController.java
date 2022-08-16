package com.emp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.Model.Employee;
import com.emp.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService empservice;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Bhaskar";
	}
	
	@PostMapping("/employee")
	Integer createEmployee(@RequestBody Employee employee) {
		Integer id=empservice.saveEmployee(employee);
		return id;
	}
	
	@GetMapping("/getAllEmployee")
 public	List<Employee> getEmployee(){
	return empservice.getAllEmployee();
		
	}
}
