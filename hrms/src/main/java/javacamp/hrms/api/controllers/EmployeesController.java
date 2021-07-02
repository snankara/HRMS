package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Employee employee) {
		return this.employeeService.update(employee);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody Employee employee) {
		return this.employeeService.delete(employee);
	}
	
	@GetMapping("/findById")
	public Result findById(int id) {
		return this.employeeService.findById(id);
	}
	
	@GetMapping("/getAll")
	public Result getAll() {
		return this.employeeService.getAll();
	}	
}
