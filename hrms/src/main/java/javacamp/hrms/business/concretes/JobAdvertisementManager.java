package javacamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javacamp.hrms.business.abstracts.JobAdvertisementService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdvertisementDao;
import javacamp.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Added!");
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		
		return null;
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		
		return null;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"Data Listed!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActive(@RequestParam boolean isActive) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(isActive));
	}

	@Override
	public Result activateJobAdvertisement(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setActive(true);
		jobAdvertisement.setStartDate(LocalDate.now());		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Successfuly!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByActiveAndPageable(boolean isActive, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);		
		 
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActive(isActive,pageable));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByCityName(String cityName,String workingTimeName) {		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByCity_CityNameAndWorkingTime_WorkingTimeName(cityName,workingTimeName),"Data Listed");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByEmployerId(int id) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByEmployer_Id(id));
	}

}
