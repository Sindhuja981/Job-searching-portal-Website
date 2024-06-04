package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Docunments;

public interface DocunmentRepository extends JpaRepository<Docunments, Integer>{

	
	
		List<Docunments> findByJobsekersUserId(int userId);
		 
	
}
