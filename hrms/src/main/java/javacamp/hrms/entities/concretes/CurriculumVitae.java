package javacamp.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "curriculum_vitae")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
	private List<Education> educations;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
	private List<Experience> experiences;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
	private List<Language> languages;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
	private List<Technology> technologies;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculum_vitae_id", referencedColumnName = "id")
	private List<CandidateImage> candidateImages;

	
}
