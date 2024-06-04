package com.example.entity;

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
@Table(name="test")
@Data
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="testId")
	private int testId;
	
	@ManyToOne
	@JoinColumn(name="vacancyId", referencedColumnName ="vacancyId")
	private Vacancies vacancies;
	
	@Column(name="testDate")
	private String testDate;
	
	@Column(name="testDuration")
	private String testDuration;
	
	
}
