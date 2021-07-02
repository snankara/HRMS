package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.EmployerForUpdate;

@RequestMapping("/api/employers")
@RestController
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("/findById")
	public DataResult<Employer> findById(int id){
		return this.employerService.findById(id);
	}
	
	@GetMapping("/findByVerifiedByEmployee")
	public DataResult<List<Employer>> findByVerifiedByEmployee(boolean verifiedByEmployee){
		return this.employerService.findByVerifiedByEmployee(verifiedByEmployee);
	}
	
	@GetMapping("/findByUpdateConfirmation")
	public DataResult<List<Employer>> findByUpdateConfirmation(boolean updateConfirmation){
		return this.employerService.findByUpdateConfirmation(updateConfirmation);
	}


	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody EmployerForUpdate employerForUpdate) {
		return this.employerService.update(employerForUpdate);
	}

	@PutMapping("/confirmUpdate")
	public Result confirmUpdate(@RequestBody EmployerForUpdate employerForUpdate) {
		return this.employerService.confirmUpdate(employerForUpdate);
	}

}
