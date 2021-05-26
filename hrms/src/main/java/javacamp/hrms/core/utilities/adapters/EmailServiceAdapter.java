package javacamp.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import javacamp.hrms.core.utilities.abstracts.EmailValidationService;
import javacamp.hrms.entities.concretes.User;

@Service
public class EmailServiceAdapter implements EmailValidationService {

	@Override
	public boolean validate(User user) {
		//Email validaton logic...

		return true;
	}

}
