package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingService {
	Result add(TypeOfWorking typeOfWorking);
	DataResult<List<TypeOfWorking>> getAll();
}
