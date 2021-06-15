package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.TypeOfWorkingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.TypeOfWorkingDao;
import javacamp.hrms.entities.concretes.TypeOfWorking;

@Service
public class TypeOfWorkingManager implements TypeOfWorkingService{
	
	private TypeOfWorkingDao typeOfWorkingDao;
	
	@Autowired
	public TypeOfWorkingManager(TypeOfWorkingDao typeOfWorkingDao) {
		this.typeOfWorkingDao = typeOfWorkingDao;
	}

	@Override
	public Result add(TypeOfWorking typeOfWorking) {
		this.typeOfWorkingDao.save(typeOfWorking);
		return new SuccessResult("Added!");
	}

	@Override
	public DataResult<List<TypeOfWorking>> getAll() {
		
		return new SuccessDataResult<List<TypeOfWorking>>(this.typeOfWorkingDao.findAll(),"Listed!");
	}
}
