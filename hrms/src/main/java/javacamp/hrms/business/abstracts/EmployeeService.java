package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;
import javacamp.hrms.entities.concretes.Employer;


public interface EmployeeService {
	Result add(Employee employee);
	Result update(Employee employee);
	Result delete(Employee employee);
	DataResult<List<Employee>> getAll();
	DataResult<Employee> findById(int id);
	Result validateEmployer(Employer employer);

}
