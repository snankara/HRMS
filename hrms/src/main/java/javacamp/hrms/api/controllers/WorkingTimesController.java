package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.WorkingTimeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {
	
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		this.workingTimeService = workingTimeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingTime workingTime){
		return this.workingTimeService.add(workingTime);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll(){
		return this.workingTimeService.getAll();
	}


}
