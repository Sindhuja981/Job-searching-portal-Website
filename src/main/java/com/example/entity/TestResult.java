package com.example.entity;

import java.sql.Date;

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
@Data
@Table(name="testResult")
public class TestResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testResultId")
	private int testResultId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private JobSekers jobseker;
	
	@ManyToOne
	@JoinColumn(name="questionId")
	private Questions question;
	
	@ManyToOne
	@JoinColumn(name="vacancyId")
	private Vacancies vacancies;
	
	@Column(name = "selectedOption")
	private String selectedOption;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "score")
	private String score;

}
