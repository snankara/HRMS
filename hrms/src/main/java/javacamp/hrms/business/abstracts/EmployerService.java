package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerService {
	Result add(Employer employer);
	Result update(EmployerForUpdate employerForUpdate);
	Result confirmUpdate(EmployerForUpdate employerForUpdate);
	Result delete(Employer employer);
	DataResult<List<Employer>> getAll();
	DataResult<Employer> findById(int id);
	DataResult<List<Employer>> findByVerifiedByEmployee(boolean verifiedByEmployee);
	DataResult<List<Employer>> findByUpdateConfirmation(boolean updateConfirmation);
}
