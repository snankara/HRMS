package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Result delete(Candidate candidate);
	DataResult<List<Candidate>> getAll();
}
