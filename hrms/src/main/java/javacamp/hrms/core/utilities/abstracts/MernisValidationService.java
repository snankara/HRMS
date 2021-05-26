package javacamp.hrms.core.utilities.abstracts;

import javacamp.hrms.entities.concretes.Candidate;

public interface MernisValidationService {
	boolean validate(Candidate candidate);
}
