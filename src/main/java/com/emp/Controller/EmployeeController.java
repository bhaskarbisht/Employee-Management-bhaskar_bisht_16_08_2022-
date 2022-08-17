package com.emp.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		Integer id = empservice.saveEmployee(employee);
		return id;
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getEmployees() {
		return empservice.getAllEmployee();

	}

	@GetMapping("/getemployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {

		Optional<Employee> employee = empservice.getEmployee(id);
		return employee;
	}

	@DeleteMapping("/deleteemployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
		System.out.println(id);
		ResponseEntity<Employee> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			empservice.deleteEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
