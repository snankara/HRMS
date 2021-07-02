package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.business.abstracts.EmployerForUpdateService;
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
import javacamp.hrms.entities.concretes.EmployerForUpdate;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailValidationService emailValidatonService;
	private EmployeeService employeeService;
	private EmployerForUpdateService employerForUpdateService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, 
			EmailValidationService emailValidatonService, 
			EmployeeService employeeService,
			EmployerForUpdateService employerForUpdateService) {
		
		this.employerDao = employerDao;
		this.emailValidatonService = emailValidatonService;
		this.employeeService = employeeService;
		this.employerForUpdateService = employerForUpdateService;
	}

	@Override
	public Result add(@RequestBody Employer employer) {	
		if (!this.employerExists(employer.getEmail())) {
			return new ErrorResult("Employer Available!");
		}
		
		if (!this.emailValidatonService.validate(employer)) {
			return new ErrorResult("Please verify your email.");
		}
		
		if (!this.employeeService.validateEmployer(employer).isSuccess()) {
			return new ErrorResult("Please wait for HRMS staff to verify you.");
		}
		
		if (!CompanyEmailPattern.isValidPattern(employer.getWebSite(), employer.getEmail())) {
			return new ErrorResult("E postanız web siteniz ile aynı domaine sahip olmalı");
		}
		
		if (!this.passwordCheck(employer.getPassword(), employer.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		
		employer.setVerifiedByEmail(true);
		employer.setUpdateConfirmation(true);
		this.employerDao.save(employer);
		return new SuccessResult("Added!");
	}

	@Override
	public Result update(EmployerForUpdate employerForUpdate) {
		if (!this.passwordCheck(employerForUpdate.getPassword(), employerForUpdate.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		Employer employer = this.findById(employerForUpdate.getId()).getData();
		employer.setUpdateConfirmation(false);
		employerForUpdate.setVerifiedByEmail(true);
		employerForUpdate.setUpdateConfirmation(false);
		employerForUpdate.setVerifiedByEmployee(true);
		this.employerForUpdateService.add(employerForUpdate);
		return new SuccessResult("Updated");
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
	
	@Override
	public DataResult<Employer> findById(int id) {
		
		return new SuccessDataResult<Employer>(this.employerDao.findById(id));
	}

	@Override
	public Result confirmUpdate(EmployerForUpdate employerForUpdate) {
		Employer employer = this.employerDao.findById(employerForUpdate.getId());
		employer.setId(employerForUpdate.getId());
		employer.setEmail(employerForUpdate.getEmail());
		employer.setPassword(employerForUpdate.getPassword());
		employer.setPasswordRepeat(employerForUpdate.getPasswordRepeat());
		employer.setCompanyName(employerForUpdate.getCompanyName());
		employer.setWebSite(employerForUpdate.getWebSite());		
		employer.setPhoneNumber(employerForUpdate.getPhoneNumber());
		employer.setUpdateConfirmation(true);
		employer.setVerifiedByEmail(true);
		employer.setUpdateConfirmation(true);
		this.employerDao.save(employer);
		this.employerForUpdateService.delete(employerForUpdate);
		return new SuccessResult("Employer Confirmed");
	}
	
	@Override
	public DataResult<List<Employer>> findByVerifiedByEmployee(boolean verifiedByEmployee) {		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByVerifiedByEmployee(verifiedByEmployee));
	}

	@Override
	public DataResult<List<Employer>> findByUpdateConfirmation(boolean updateConfirmation) {		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findByUpdateConfirmation(updateConfirmation));
	}

	
	private boolean employerExists(String email) {
		if (this.employerDao.findByEmail(email) == null) {
			return true;
		}		
		return false;
	}
	
	private boolean passwordCheck(String password, String passwordRepeat) {
		if (password.toLowerCase().equals(passwordRepeat.toLowerCase())) {
			return true;
		}		
		return false;
	}
	
}
