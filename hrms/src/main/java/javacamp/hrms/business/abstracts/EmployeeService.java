package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;

public interface EmployeeService {
	boolean validate(Employer employer);
//	Result activateJobAdvertisement(JobAdver);
}
