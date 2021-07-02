package javacamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae);
	Result update(CurriculumVitae curriculumVitae);
	Result deleteById(int curriculumVitaeId);
	DataResult<CurriculumVitae> findById(int curriculumVitaeId);
	DataResult<List<CurriculumVitae>> findByCandidateId(int candidateId);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<List<CurriculumVitae>> getByCandidateIdLastItem(int candidateId);
	
}
