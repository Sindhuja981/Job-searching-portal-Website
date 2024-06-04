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

@Data
@Entity
@Table(name = "selectedcandidates")
public class SelectedCandidates {
	
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;

		@ManyToOne
		@JoinColumn(name = "vacancyId", referencedColumnName = "vacancyId")
		private Vacancies vacancies;

		@ManyToOne
		@JoinColumn(name = "testId", referencedColumnName = "testId")
		private Test test;

		@ManyToOne
		@JoinColumn(name = "userId", referencedColumnName = "userId")
		private JobSekers jobSekers;

		@Column(name = "score")
		private int score;

		@Column(name = "status")
		private String status;

}

