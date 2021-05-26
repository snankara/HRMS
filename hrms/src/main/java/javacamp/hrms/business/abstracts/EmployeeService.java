package javacamp.hrms.business.abstracts;


import javacamp.hrms.entities.concretes.Employer;


public interface EmployeeService {
	boolean validate(Employer employer);
}
