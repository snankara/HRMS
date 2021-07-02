package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmployerForUpdateService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerForUpdateDao;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.EmployerForUpdate;

@Service
public class EmployerForUpdateManager implements EmployerForUpdateService{

	
	private EmployerForUpdateDao employerForUpdateDao;
	private EmployerService employerService;
	
	@Autowired
	public EmployerForUpdateManager(EmployerForUpdateDao employerForUpdateDao, @Lazy EmployerService employerService) {
		this.employerForUpdateDao = employerForUpdateDao;
		this.employerService = employerService;
	}

	@Override
	public Result add(EmployerForUpdate employerForUpdate) {
		this.employerForUpdateDao.save(employerForUpdate);
		return new SuccessResult("Added for update");
	}

	@Override
	public Result update(EmployerForUpdate employerForUpdate) {
		Employer employer = this.employerService.findById(employerForUpdate.getId()).getData();
		System.out.println(employer);
		return null;
	}

	@Override
	public Result delete(EmployerForUpdate employerForUpdate) {
		this.employerForUpdateDao.deleteById(employerForUpdate.getId());
		return new SuccessResult("Deleted");
	}

	@Override
	public DataResult<List<EmployerForUpdate>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<EmployerForUpdate> findById(int id) {
		
		return new SuccessDataResult<EmployerForUpdate>(this.employerForUpdateDao.findById(id));
	}
}
