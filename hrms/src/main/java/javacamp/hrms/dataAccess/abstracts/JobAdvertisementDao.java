package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findByIsActive(boolean isActive,Pageable pageable);
	List<JobAdvertisement> findByIsActive(boolean isActive);
	JobAdvertisement findById(int id);
}
