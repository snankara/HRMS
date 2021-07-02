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

import javacamp.hrms.business.abstracts.JobAdvertisementService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/findByCityNameAndWorkingTime")
	public DataResult<List<JobAdvertisement>> findByCityName(String cityName,String workingTimeName){
		return this.jobAdvertisementService.findByCityName(cityName,workingTimeName);
	}

	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive){
		return this.jobAdvertisementService.findByIsActive(isActive);
	}
	
	@PutMapping("/activateJobAdvertisement")
	public Result activateJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.activateJobAdvertisement(jobAdvertisement);
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize){
		return this.jobAdvertisementService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllByActiveAndPageable")
	public DataResult<List<JobAdvertisement>> getAllByActiveAndPageable(boolean isActive, int pageNo, int pageSize){
		return this.jobAdvertisementService.getAllByActiveAndPageable(isActive,pageNo,pageSize);
	}

	@GetMapping("/findByEmployerId")
	public DataResult<List<JobAdvertisement>> findByEmployerId(int id){
		return this.jobAdvertisementService.findByEmployerId(id);
	}

	
}
