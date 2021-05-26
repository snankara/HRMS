package javacamp.hrms.business.concretes;

import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployeeManager implements EmployeeService{

	@Override
	public boolean validate(Employer employer) {
		//Validation logic...
		employer.setVerifiedByEmployee(true);
		return true;
	}

}
