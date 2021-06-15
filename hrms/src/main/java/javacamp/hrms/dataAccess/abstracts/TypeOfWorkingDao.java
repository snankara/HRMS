package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.TypeOfWorking;

public interface TypeOfWorkingDao extends JpaRepository<TypeOfWorking, Integer>{

}
