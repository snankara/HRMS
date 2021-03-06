package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {

	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@GetMapping("/getByPositionName")
	public DataResult<JobPosition> getByPositionName(String positionName){
		return this.jobPositionService.findByPositionName(positionName);
	}
	
	@GetMapping("/getByPositionNameContains")
	public DataResult<List<JobPosition>> getByPositionNameContains(String positionName){
		return this.jobPositionService.findByPositionNameContains(positionName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition){
		return this.jobPositionService.add(jobPosition);
	}
}
