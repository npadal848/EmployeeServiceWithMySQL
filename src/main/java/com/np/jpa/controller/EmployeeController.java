package com.np.jpa.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.np.jpa.dao.EmployeeRepo;
import com.np.jpa.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@GetMapping("/message")
	public String message() {
		return "Welcome "+Calendar.getInstance().getTime();
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = (List<Employee>) repo.findAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
}
