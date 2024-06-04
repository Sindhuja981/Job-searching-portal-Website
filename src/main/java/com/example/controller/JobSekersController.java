package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JobSekers;
import com.example.entity.Company;
import com.example.entity.JobApply;
import com.example.service.JobSekersService;

@RestController
@RequestMapping("/api/v1")
public class JobSekersController {
	@Autowired
	JobSekersService jobSekersService;
	
	@PostMapping(value="/AddJobSeker")
	public  ResponseEntity<Object> addJobSekers(@RequestBody JobSekers jobsekers){
		jobSekersService.addJobSekers(jobsekers);
		return new ResponseEntity<>("JobSekers added successfully", HttpStatus.CREATED);
		
	}
	@GetMapping(value="/allJobSekers")
	public ResponseEntity<Object> getAllJobSekers(){
		List<JobSekers> jobSekers = jobSekersService.getAllJobSekers();
		ResponseEntity<Object> entity = new ResponseEntity<>(jobSekers, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteJobSekers/{userId}")
	public ResponseEntity<Object> deleteJobSekers(@PathVariable("userId") int userId){
		boolean flag;
		if(jobSekersService.deleteJobSekers(userId)) {
			flag = jobSekersService.deleteJobSekers(userId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getJobSekers/{userId}")
    public ResponseEntity<Object> getJobSekersById(@PathVariable("userId") int userId) {
		JobSekers jobSekers = jobSekersService.getJobSekersById(userId);
        if (jobSekers != null) {
            return new ResponseEntity<>(jobSekers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("jobSekers not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updateJobSekers/{userId}")
	public ResponseEntity<Object> updateJobSekersId(@PathVariable("userId") int userId, @RequestBody JobSekers jobSekers)
	{
		boolean flag;
		if(jobSekersService.isJobSekersExist(userId)) {
			flag = jobSekersService.updateJobSekersId(jobSekers);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping(value="/JobSekerLogin/{email}")
	public  ResponseEntity<Object> loginValidate(@PathVariable("email") String email){
		JobSekers flag = jobSekersService.loginValidate(email);
		return new ResponseEntity<>(flag,HttpStatus.OK);
	}
	
}
