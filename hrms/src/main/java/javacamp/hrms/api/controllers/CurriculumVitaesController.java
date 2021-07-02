package javacamp.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CandidateImageService;
import javacamp.hrms.business.abstracts.CurriculumVitaeService;
import javacamp.hrms.business.abstracts.EducationService;
import javacamp.hrms.business.abstracts.ExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CurriculumVitae;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/curriculumVitaes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurriculumVitaesController {

	private CurriculumVitaeService curriculumVitaeService;
	private CandidateImageService candidateImageService;
	private EducationService educationService;
	private ExperienceService experienceService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService,
			CandidateImageService candidateImageService,
			EducationService educationService,
			ExperienceService experienceService) {
		
		this.curriculumVitaeService = curriculumVitaeService;
		this.candidateImageService = candidateImageService;
		this.educationService = educationService;
		this.experienceService = experienceService;
	}
	
	@PostMapping(value= "/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.add(curriculumVitae); 
	}
	
	@PutMapping(value= "/update")
	public Result update(@RequestBody CurriculumVitae curriculumVitae) {
		return this.curriculumVitaeService.update(curriculumVitae); 
	}

	@PostMapping(value= "/addImage")
	public Result add(int id, @RequestBody MultipartFile file) {
	    return this.candidateImageService.add(id, file);
	}
	
	@PostMapping(value= "/deleteById")
	public Result deleteById(int curriculumVitaeId) {
	    return this.curriculumVitaeService.deleteById(curriculumVitaeId);
	}

	
	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@GetMapping("/findById")
	public DataResult<CurriculumVitae> findById(int curriculumVitaeId){
		return this.curriculumVitaeService.findById(curriculumVitaeId);
	}

	
	@GetMapping("/getAllCandidateEducationEndDateDesc")
	public DataResult<List<Education>> getAllEducationDesc(){
		return this.educationService.getAllSorted();
	}
	
	@GetMapping("/getByCandidateIdLastItem")
	public DataResult<List<CurriculumVitae>> getByCandidateIdLastItem(@RequestParam int candidateId){
		return this.curriculumVitaeService.getByCandidateIdLastItem(candidateId);
	}

	
	@GetMapping("/getAllCandidateExperienceEndDateDesc")
	public DataResult<List<Experience>> getAllExperienceDesc(){
		return this.experienceService.getAllSorted();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult <List<CurriculumVitae>> findByCandidateId(@RequestParam int candidateId){
		return this.curriculumVitaeService.findByCandidateId(candidateId);
	}
	
}
