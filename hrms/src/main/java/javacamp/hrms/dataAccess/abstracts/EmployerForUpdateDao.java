package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.EmployerForUpdate;

public interface EmployerForUpdateDao extends JpaRepository<EmployerForUpdate, Integer>{
	EmployerForUpdate findById(int id);
}
