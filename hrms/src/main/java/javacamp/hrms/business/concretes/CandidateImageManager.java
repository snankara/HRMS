package javacamp.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CandidateImageService;
import javacamp.hrms.core.utilities.abstracts.CloudinaryImageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateImageDao;
import javacamp.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService{
	
	
	private CandidateImageDao candidateImageDao;
	private CloudinaryImageService cloudinaryImageService;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao, CloudinaryImageService cloudinaryImageService) {
		this.candidateImageDao = candidateImageDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}
	
	@Override
	public Result add(int id, MultipartFile file) {
		Map<String, String> uploadFile = this.cloudinaryImageService.uploadImage(file).getData();
		CandidateImage candidateImage = this.candidateImageDao.findByCurriculumVitaeId(id);
		candidateImage.setImageUrl(uploadFile.get("url"));
		this.candidateImageDao.save(candidateImage);
		return new SuccessResult("File Added!");
	}

	@Override
	public DataResult<CandidateImage> findByCurriculumVitaeId(int curriculumVitaeId) {
		
		return new SuccessDataResult<CandidateImage>(this.candidateImageDao.findByCurriculumVitaeId(curriculumVitaeId));
	}

}
