package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.FavouriteService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Favourite;

@RestController
@RequestMapping("/api/favourites")
@CrossOrigin
public class FavouritesController {
	
	@Autowired
	private FavouriteService favouriteService;
	
	@GetMapping("/getAll")
	public DataResult<List<Favourite>> getAll(){
		return this.favouriteService.getAll();
	}
	
	@GetMapping("/findById")
	public DataResult<Favourite> findById(int id){
		return this.favouriteService.findById(id);
	}
	
	@GetMapping("/findByCandidateId")
	public DataResult<List<Favourite>> findByCandidateId(int candidateId){
		return this.favouriteService.findByCandidateId(candidateId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Favourite favourite){
		return this.favouriteService.add(favourite);
	}
	
	@PostMapping("deleteById")
	public Result deleteById(int favouriteId){
		return this.favouriteService.deleteById(favouriteId);
	}
	


}
