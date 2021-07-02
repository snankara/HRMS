package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer>{
	CurriculumVitae findById(int curriculumVitaeId);
	List<CurriculumVitae> findByCandidateId(int candidateId);
	List<CurriculumVitae> findByCandidateId(int candidateId, Sort sort);
}
