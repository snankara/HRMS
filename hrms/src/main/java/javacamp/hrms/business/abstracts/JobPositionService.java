package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	Result add(JobPosition jobPosition);
	Result update(JobPosition jobPosition);
	Result delete(JobPosition jobPosition);
	DataResult<List<JobPosition>> getAll();
}
