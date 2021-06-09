package javacamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	CurriculumVitae findById(int curriculumVitaeId);
}
