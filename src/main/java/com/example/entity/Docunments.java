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
@Table(name="Docunments")
@Data
public class Docunments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="documentsId")
	private int documentsId;

	@ManyToOne
	@JoinColumn(name="userId")
	private JobSekers jobsekers;
	
	@Column(name="documentsType")
	private String documentsType;
	
	@Column(name="documentsFile")
	private String documentsFile;
	
}
