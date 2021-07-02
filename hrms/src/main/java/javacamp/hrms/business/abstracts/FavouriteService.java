package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Favourite;

public interface FavouriteService {
	Result add(Favourite favourite);
	Result deleteById(int favouriteId);
	DataResult<List<Favourite>> getAll();
	DataResult<Favourite> findById(int id);
	DataResult<List<Favourite>> findByCandidateId(int candidateId);
}
