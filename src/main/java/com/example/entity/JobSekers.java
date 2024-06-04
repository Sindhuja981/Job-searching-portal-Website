package com.example.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name="jobsekers")
public class JobSekers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int userId;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "regDate")
	private Date regDate;
	
	@Column(name = "dateOfBirth")
	private String dateofbirth;
	
	
	@Column(name = "gender")
	private String gender;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "profilePic")
	private String profilePic;
	
	@Column(name = "qualifications")
	private String qualifications;
	
	@Column(name = "experience")
	private String experience;
}