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

@Data
@Entity
@Table(name = "jobapply")
public class JobApply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "applyId")
	private int applyId;

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private JobSekers jobsekers;

	@ManyToOne
	@JoinColumn(name = "vacancyId", referencedColumnName = "vacancyId")
	private Vacancies vacancies;

	@CreationTimestamp
	@Column(name = "applyDate")
	private String applyDate;
	
	@Column(name= "status")
	private String status;
	
	@Column(name= "finalScore")
	private String finalscore;

}

