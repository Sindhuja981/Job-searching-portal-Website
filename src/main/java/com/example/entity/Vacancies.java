package com.example.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="vacancies")
@Data
public class Vacancies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vacancyId")
	private int vacancyId;
	
	@ManyToOne
	@JoinColumn(name="companyId", referencedColumnName = "companyId")
	private Company company;
	
	@Column(name="postDate")
	@CreationTimestamp
	private String postDate;
	
	@Column(name="jobTitle")
	private String jobTitle;
	
	@Column(name="description")
	private String description;
	
	@Column(name="requirements")
	private String requirements;
	
	@Column(name="noOfVancancies")
	private int  noOfVancancies;
	
	@Column(name="OpenDate")
	private String OpenDate;
	
	@Column(name="closeDate")
	private String closeDate;
	
}
