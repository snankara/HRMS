package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.abstracts.EmailValidationService;
import javacamp.hrms.core.utilities.helpers.CompanyEmailPattern;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailValidationService emailValidatonService;
	private EmployeeService employeeService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, 
			EmailValidationService emailValidatonService, EmployeeService employeeService) {
		this.employerDao = employerDao;
		this.emailValidatonService = emailValidatonService;
		this.employeeService = employeeService;
	}

	@Override
	public Result add(@RequestBody Employer employer) {	
		if (!this.employerExists(employer.getEmail())) {
			return new ErrorResult("Employer Available!");
		}
		
		if (!this.emailValidatonService.validate(employer)) {
			return new ErrorResult("Please verify your email.");
		}
		
		if (!this.employeeService.validate(employer)) {
			return new ErrorResult("Please wait for HRMS staff to verify you.");
		}
		
		if (!CompanyEmailPattern.isValidPattern(employer.getWebSite(), employer.getEmail())) {
			return new ErrorResult("E postanız web siteniz ile aynı domaine sahip olmalı");
		}
		employer.setVerifiedByEmail(true);
		this.employerDao.save(employer);
		return new SuccessResult("Added!");
	}

	@Override
	public Result update(Employer employer) {
		
		return null;
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessResult("Deleted!");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Listed!");
	}
	
	private boolean employerExists(String email) {
		if (this.employerDao.findByEmail(email) == null) {
			return true;
		}
		
		return false;
	}

}
