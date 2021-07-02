package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerForUpdateService {
	Result add(EmployerForUpdate employerForUpdate);
	Result update(EmployerForUpdate employerForUpdate);
	Result delete(EmployerForUpdate employerForUpdate);
	DataResult<List<EmployerForUpdate>> getAll();
	DataResult<EmployerForUpdate> findById(int id);

}
