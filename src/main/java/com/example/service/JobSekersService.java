package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.JobSekers;
import com.example.entity.Company;

@Service
public interface JobSekersService {
	void addJobSekers(JobSekers jobSeker);
	List<JobSekers> getAllJobSekers();
	boolean isJobSekersExist(int userId);
	JobSekers getJobSekersById(int userId);
	boolean deleteJobSekers(int userId);
	boolean updateJobSekersId(JobSekers jobSeker);
	JobSekers loginValidate(String email);

}
