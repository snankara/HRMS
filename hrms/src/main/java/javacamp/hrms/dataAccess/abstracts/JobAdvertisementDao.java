package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findByIsActive(boolean isActive,Pageable pageable);
	List<JobAdvertisement> findByIsActive(boolean isActive);
	List<JobAdvertisement> findByCity_CityNameAndWorkingTime_WorkingTimeName(String cityName, String workingTimeName);
	JobAdvertisement findById(int id);
	List<JobAdvertisement> findByEmployer_Id(int id);
}
