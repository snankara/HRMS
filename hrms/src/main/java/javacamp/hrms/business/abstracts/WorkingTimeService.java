package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	Result add(WorkingTime workingTime);
	DataResult<List<WorkingTime>> getAll();
}
