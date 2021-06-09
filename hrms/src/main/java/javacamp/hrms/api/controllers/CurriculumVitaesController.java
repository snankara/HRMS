package javacamp.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping(value= "/addImage")
	public Result add(int curriculumVitaeId, @RequestBody MultipartFile file) {
	    return this.candidateImageService.add(curriculumVitaeId, file);
	}

	
	@GetMapping("/getAll")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@GetMapping("/getAllCandidateEducationEndDateDesc")
	public DataResult<List<Education>> getAllEducationDesc(){
		return this.educationService.getAllSorted();
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
