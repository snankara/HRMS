package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "position_name")
	private String positionName;
	
	
//	@OneToMany(mappedBy = "jobPosition")
//	private List<Candidate> candidates;
//	
//	
//	@OneToMany(mappedBy = "jobPosition")
//	private List<JobAdvertisement> jobAdvertisements;
}
