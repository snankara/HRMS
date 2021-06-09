package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae);
	DataResult<List<CurriculumVitae>> findByCandidateId(int candidateId);
	DataResult<List<CurriculumVitae>> getAll();
	
}
