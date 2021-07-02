package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	Employer findById(int id);
	Employer findByEmail(String email);
	List<Employer> findByVerifiedByEmployee(boolean verifiedByEmployee);
	List<Employer> findByUpdateConfirmation(boolean updateConfirmation);
}
