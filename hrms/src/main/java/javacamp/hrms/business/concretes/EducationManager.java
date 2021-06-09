package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.EducationDao;
import javacamp.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{
	
	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"endDate");		
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort), "Data Listed");
	}
		
}
