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


import com.example.entity.JobApply;
import com.example.service.JobApplyService;

@RestController
@RequestMapping("/api/v1")
public class JobApplyController {
	@Autowired
	JobApplyService jobApplyService;
	
	@PostMapping(value="/AddJobApply")
	public ResponseEntity<Object> addJobApply(@RequestBody JobApply jobapply){
		jobApplyService.addjobApply(jobapply);
		return new ResponseEntity<>("JobApply added successfully", HttpStatus.CREATED);
	}
	@GetMapping(value="/alljobApply")
	public ResponseEntity<Object> getAllJobApply(){
		List<JobApply> JobApply = jobApplyService.getAlljobApply();
		ResponseEntity<Object> entity = new ResponseEntity<>(JobApply, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteJobApply/{jobApplyId}")
	public ResponseEntity<Object> deleteJobapply(@PathVariable("jobApplyId") int jobApplyId){
		boolean flag;
		if(jobApplyService.deletejobApply(jobApplyId)) {
			flag = jobApplyService.deletejobApply(jobApplyId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);	
	}
	@GetMapping(value = "/getjobApply/{applyId}")
    public ResponseEntity<Object> getJobApplyById(@PathVariable("applyId") int applyId) {
        JobApply JobApply = jobApplyService.getjobApplyById(applyId);
        if (JobApply != null) {
            return new ResponseEntity<>(JobApply, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("JobApply not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping(value="/findByUserIdInJobApply/{userId}")
	public ResponseEntity<Object> findByUserIdInJobApply(@PathVariable("userId") int userId){
		List<JobApply> vacancy = jobApplyService.findByJobsekerUserId(userId);
		ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
		return entity;
	}
	@PutMapping("/updatestat/{userId}/{status}/{finalScore}/{vacancyId}")
	public ResponseEntity<String> updateStatusByUserId(@PathVariable int userId,@PathVariable int vacancyId ,@PathVariable String status,@PathVariable String finalScore)

	{
		jobApplyService.updateStatusByUserId(userId, status,finalScore, vacancyId);

		return ResponseEntity.ok("Status updated successfully");
	}
	@GetMapping(value="/findByCompanyIdInJobApply/{companyId}")
	public ResponseEntity<Object> findByCompanyId(@PathVariable("companyId") int companyId){
		List<JobApply> vacancy = jobApplyService.findByCompanyId(companyId);
		ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
		return entity;
	}
	@GetMapping("/check/{vacancyId}/{userId}")
    public ResponseEntity<Boolean> checkJobApplication(@PathVariable int vacancyId, @PathVariable int userId) {
        boolean exists = jobApplyService.existsByVacancyIdAndUserId(vacancyId, userId);
        return ResponseEntity.ok(exists);
    }
}
