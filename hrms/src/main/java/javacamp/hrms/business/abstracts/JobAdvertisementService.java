package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> getAllByActiveAndPageable(boolean isActive, int pageNo, int pageSize);
	Result activateJobAdvertisement(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);	
	DataResult<List<JobAdvertisement>>findByCityName(String cityName,String workingTimeName);
	DataResult<List<JobAdvertisement>> findByEmployerId(int id);
}
