package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.Favourite;

public interface FavouriteDao extends JpaRepository<Favourite, Integer>{
	Favourite findById(int id);
	List<Favourite> findByCandidateId(int candidateId);
}
