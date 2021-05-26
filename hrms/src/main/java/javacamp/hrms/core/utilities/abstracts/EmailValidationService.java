package javacamp.hrms.core.utilities.abstracts;


import javacamp.hrms.entities.concretes.User;

public interface EmailValidationService {
	boolean validate(User user);
}
