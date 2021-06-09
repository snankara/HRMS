package javacamp.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CurriculumVitaeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javacamp.hrms.entities.concretes.CurriculumVitae;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Experience;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	
	private CurriculumVitaeDao curriculumVitaeDao;	
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		
		this.checkExperienceEndDate(curriculumVitae.getExperiences());
		this.checkEducationEndDate(curriculumVitae.getEducations());
		
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Added!");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {	
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"Data Listed");
	}
	
	private void checkExperienceEndDate(List<Experience> experiences) {
		for (Experience experience : experiences) {
			if (experience.getEndDate() == null) {			
				experience.setEndDate("Present");			
			}
		}		
	}
	
	private void checkEducationEndDate(List<Education> educations) {
		for (Education education : educations) {
			if (education.getEndDate() == null) {			
				education.setEndDate("Present");			
			}
		}	
	}

}
