package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result add(@RequestBody JobPosition jobPosition) {
		
		if (!this.jobPositionExists(jobPosition.getPositionName())) {
			return new ErrorResult("Job position available");
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Added!");
	}

	@Override
	public Result update(@RequestBody JobPosition jobPosition) {
		return new SuccessResult("Updated!");
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("Deleted!");
		
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Listed!");
	}
	
	private boolean jobPositionExists(String positionName) {
		if (this.jobPositionDao.findByPositionName(positionName) == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public DataResult<JobPosition> findByPositionName(@RequestParam String positionName) {
		
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(positionName),"Data Listed!");
	}

	@Override
	public DataResult<List<JobPosition>> findByPositionNameContains(@RequestParam String positionName) {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findByPositionNameContains(positionName), "Data Listed!");
	}

}
