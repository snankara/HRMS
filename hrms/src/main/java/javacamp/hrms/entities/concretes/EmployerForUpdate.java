package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "update_for_employers")
public class EmployerForUpdate{
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "password_repeat")
	private String passwordRepeat;	
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_site")
	private String webSite;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "verified_by_employee")
	private boolean verifiedByEmployee;
	
	@Column(name = "update_confirmation")
	private boolean updateConfirmation;
	
	@Column(name = "verified_by_email")
	private boolean verifiedByEmail;
	
}
