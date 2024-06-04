package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.JobSekers;


public interface JobSekersRepository extends JpaRepository<JobSekers,Integer>{
	
	public JobSekers findByEmail(String email);

	

}
