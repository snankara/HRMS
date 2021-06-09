package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.ExperienceDao;
import javacamp.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");		
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(sort), "Data Listed");
	}

}
