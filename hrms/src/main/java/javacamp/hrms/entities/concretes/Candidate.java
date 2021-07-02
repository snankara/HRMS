package javacamp.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class Candidate extends User{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	
	@Column(name = "national_identity")
	private String nationalIdentity;
		
	@Column(name = "verified_by_email")
	private boolean verifiedByEmail;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	private List<CurriculumVitae> curriculumVitaes;
		
}
