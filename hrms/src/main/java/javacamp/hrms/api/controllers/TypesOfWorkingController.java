package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.TypeOfWorkingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.TypeOfWorking;

@RestController
@RequestMapping("/api/typesOfWorking")
@CrossOrigin
public class TypesOfWorkingController {
	
	private TypeOfWorkingService typeOfWorkingService;

	@Autowired
	public TypesOfWorkingController(TypeOfWorkingService typeOfWorkingService) {
		this.typeOfWorkingService = typeOfWorkingService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody TypeOfWorking typeOfWorking){
		return this.typeOfWorkingService.add(typeOfWorking);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<TypeOfWorking>> getAll(){
		return this.typeOfWorkingService.getAll();
	}


}
