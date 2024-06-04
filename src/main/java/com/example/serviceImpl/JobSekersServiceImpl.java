package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobSekers;

import com.example.execption.ResourceNotFoundException;
import com.example.repository.JobSekersRepository;
import com.example.service.JobSekersService;

@Service
public class JobSekersServiceImpl implements JobSekersService{
	
	@Autowired
	JobSekersRepository jobSekersRepository;

	@Override
	public void addJobSekers(JobSekers jobSeker) {
		// TODO Auto-generated method stub
		jobSekersRepository.save(jobSeker);
		
	}

	@Override
	public List<JobSekers> getAllJobSekers() {
		// TODO Auto-generated method stub
		List<JobSekers> list = jobSekersRepository.findAll();
		return list;
	}

	@Override
	public boolean isJobSekersExist(int userId) {
		// TODO Auto-generated method stub
		Optional<JobSekers> jobSekers = jobSekersRepository.findById(userId);
		JobSekers jobSekerss;
		if(jobSekers.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public JobSekers getJobSekersById(int userId) {
		// TODO Auto-generated method stub
		Optional<JobSekers> jobSekers = jobSekersRepository.findById(userId);
		JobSekers jobSekerss;
		if(jobSekers.isPresent()) {
			jobSekerss = jobSekers.get();
		}else {
			throw new ResourceNotFoundException("JobSekers","userId", userId);
		}
		return jobSekerss;
	}

	@Override
	public boolean deleteJobSekers(int userId) {
		// TODO Auto-generated method stub
		Optional<JobSekers> jobSekers = jobSekersRepository.findById(userId);
		JobSekers jobSekerss;
		if(jobSekers.isPresent()) {
			jobSekersRepository.deleteById(userId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateJobSekersId(JobSekers jobSeker) {
		// TODO Auto-generated method stub
		Optional<JobSekers> jobSekers = jobSekersRepository.findById(jobSeker.getUserId());
		JobSekers JobSekerss;
		if(jobSekers.isPresent()) {
			jobSekersRepository.save(jobSeker);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public JobSekers loginValidate(String email) {
		// TODO Auto-generated method stub
		JobSekers jobSekers = jobSekersRepository.findByEmail(email);

		return jobSekers;
	}
	
}
