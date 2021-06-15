package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "types_of_working")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeOfWorking {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type_name")
	private String typeName;
	
	@OneToMany(mappedBy = "typeOfWorking")
	@JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;
}
