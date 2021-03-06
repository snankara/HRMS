package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CityService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getAll")
	DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
}
