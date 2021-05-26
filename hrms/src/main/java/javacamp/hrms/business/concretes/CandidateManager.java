package javacamp.hrms.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.core.utilities.abstracts.EmailValidationService;
import javacamp.hrms.core.utilities.abstracts.MernisValidationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;	
	private MernisValidationService mernisValidationService;
	private EmailValidationService emailValidationService;
	@Autowired
	public CandidateManager(MernisValidationService mernisValidationService, 
			CandidateDao candidateDao, EmailValidationService emailValidationService) {
		this.mernisValidationService = mernisValidationService;
		this.candidateDao = candidateDao;
		this.emailValidationService = emailValidationService;
	}

	@Override
	public Result add(@RequestBody Candidate candidate) {		
		if (!this.mernisValidationService.validate(candidate)) {
			return new ErrorResult("Not found in mernis !");
		}
		if (!this.candidateExists(candidate.getEmail(),candidate.getNationalIdentity())) {
			return new ErrorResult("User Available");
		}
		if (!this.emailValidationService.validate(candidate)) {
			return new ErrorResult("Please verify your email.");			
		}
		candidate.setVerifiedByEmail(true);
		this.candidateDao.save(candidate);
		return new SuccessResult("Added!");			

	}

	@Override
	public Result update(Candidate candidate) {
		
		return null;
	}

	@Override
	public Result delete(Candidate candidate) {
		
		return null;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Listed!");
	}
	
	private boolean candidateExists(String email, String nationalIdentity) {
		if (this.candidateDao.findByEmail(email) == null && 
				this.candidateDao.findByNationalIdentity(nationalIdentity) == null) {
			return true;
		}
		return false;
	}

}
