package javacamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CurriculumVitaeService;
import javacamp.hrms.core.utilities.abstracts.CloudinaryImageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import javacamp.hrms.entities.concretes.CandidateImage;
import javacamp.hrms.entities.concretes.CurriculumVitae;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Experience;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	
	private CurriculumVitaeDao curriculumVitaeDao;	
	private CloudinaryImageService cloudinaryImageService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao,CloudinaryImageService cloudinaryImageService) {
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {		
		this.checkExperienceEndDate(curriculumVitae.getExperiences());
		this.checkEducationEndDate(curriculumVitae.getEducations());
		curriculumVitae.setCreatedDate(LocalDate.now());
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

	@Override
	public DataResult <List<CurriculumVitae>> findByCandidateId(int candidateId) {
	
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findByCandidateId(candidateId));
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByCandidateIdLastItem(int candidateId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"id");			
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findByCandidateId(candidateId,sort), "Data Listed");
	}

	@Override
	public Result update(CurriculumVitae curriculumVitae) {
		CurriculumVitae currentCurriculumVitae = this.curriculumVitaeDao.findById(curriculumVitae.getId());
		currentCurriculumVitae.setCandidate(curriculumVitae.getCandidate());
		currentCurriculumVitae.setEducations(curriculumVitae.getEducations());
		currentCurriculumVitae.setExperiences(curriculumVitae.getExperiences());
		currentCurriculumVitae.setLanguages(curriculumVitae.getLanguages());
		currentCurriculumVitae.setTechnologies(curriculumVitae.getTechnologies());
		currentCurriculumVitae.setCandidateImages(curriculumVitae.getCandidateImages());
		currentCurriculumVitae.setCoverLetter(curriculumVitae.getCoverLetter());
		currentCurriculumVitae.setGithubLink(curriculumVitae.getGithubLink());
		currentCurriculumVitae.setLinkedinLink(curriculumVitae.getLinkedinLink());
		currentCurriculumVitae.setUpdatedDate(LocalDate.now());
		this.curriculumVitaeDao.save(currentCurriculumVitae);
		return new SuccessResult("Updated!");
	}

	@Override
	public DataResult<CurriculumVitae> findById(int curriculumVitaeId) {
		
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findById(curriculumVitaeId));
	}

	@Override
	public Result deleteById(int curriculumVitaeId) {
		this.curriculumVitaeDao.deleteById(curriculumVitaeId);
		return new SuccessResult("Deleted");
	}

}
