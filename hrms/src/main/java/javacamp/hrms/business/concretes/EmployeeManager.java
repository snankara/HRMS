package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployeeDao;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployeeManager implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Result add(Employee employee) {
		if (!this.passwordCheck(employee.getPassword(), employee.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employeeDao.save(employee);
		return new SuccessResult("Added !");
	}

	@Override
	public Result update(Employee employee) {
		if (!this.passwordCheck(employee.getPassword(), employee.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employeeDao.save(employee);
		return new SuccessResult("Updated !");
	}

	@Override
	public Result delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessResult("Deleted !");
	}

	@Override
	public DataResult<List<Employee>> getAll() {		
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Data Listed !");
	}

	@Override
	public DataResult<Employee> findById(int id) {		
		return new SuccessDataResult<Employee>(this.employeeDao.findById(id),"Data Listed !");
	}
	
	@Override
	public Result validateEmployer(Employer employer) {
		//Validation logic...
		employer.setVerifiedByEmployee(true);
		return new SuccessResult("Employer Verified");
	}
	
	private boolean passwordCheck(String password, String passwordRepeat) {
		if (password.toLowerCase().equals(passwordRepeat.toLowerCase())) {
			return true;
		}		
		return false;
	}



}
