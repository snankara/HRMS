package javacamp.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CandidateImage;
import javacamp.hrms.entities.concretes.CurriculumVitae;

public interface CandidateImageService {
	Result add(int curriculumVitaeId, MultipartFile file);
//	Result add(CurriculumVitae curriculumVitae, MultipartFile file);
	DataResult<CandidateImage> findByCurriculumVitaeId(int curriculumVitaeId);
}
