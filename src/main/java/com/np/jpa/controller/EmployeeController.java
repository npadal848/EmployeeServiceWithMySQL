package com.np.jpa.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.np.jpa.dao.EmployeeRepo;
import com.np.jpa.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;

	@GetMapping("/message")
	public String message() {
		return "Welcome " + Calendar.getInstance().getTime();
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = (List<Employee>) repo.findAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> getEmployeeBtId(@PathVariable Long id) {
		Optional<Employee> optEmployee = repo.findById(id);
		Employee employee = optEmployee.isPresent() ? optEmployee.get() : null;
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployeeRecord(@RequestBody Employee employee) {
		Employee response = repo.save(employee);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateEmployeeRecord(@RequestBody Employee request) {
		Optional<Employee> optEmp = repo.findById(request.getEmployeeID());
		if (optEmp.isEmpty()) {
			return new ResponseEntity<>("Employee Record Not Found with Id: " + request.getEmployeeID(),
					HttpStatus.OK);
		}
		Employee reponse = repo.save(request);
		return new ResponseEntity<>(reponse, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeRecord(@PathVariable Long id) {
		repo.deleteById(id);
		return new ResponseEntity<>("Employee Record Deleted Successfully", HttpStatus.OK);
	}
}
