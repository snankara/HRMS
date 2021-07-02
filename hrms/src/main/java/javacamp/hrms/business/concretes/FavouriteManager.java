package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.FavouriteService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.FavouriteDao;
import javacamp.hrms.entities.concretes.Favourite;

@Service
public class FavouriteManager implements FavouriteService{
	
	@Autowired
	private FavouriteDao favouriteDao;

	@Override
	public Result add(Favourite favourite) {
		this.favouriteDao.save(favourite);
		return new SuccessResult("Added");
	}

	@Override
	public Result deleteById(int favouriteId) {
		this.favouriteDao.deleteById(favouriteId);
		return new SuccessResult("Deleted");
	}

	@Override
	public DataResult<List<Favourite>> getAll() {		
		return new SuccessDataResult<List<Favourite>>(this.favouriteDao.findAll(),"Data Listed");
	}

	@Override
	public DataResult<Favourite> findById(int id) {		
		return new SuccessDataResult<Favourite>(this.favouriteDao.findById(id));
	}

	@Override
	public DataResult<List<Favourite>> findByCandidateId(int candidateId) {		
		return new SuccessDataResult<List<Favourite>>(this.favouriteDao.findByCandidateId(candidateId));
	}
}
