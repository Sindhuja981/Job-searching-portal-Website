package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.JobApply;



@Service
public interface JobApplyService {
	void addjobApply(JobApply jobApply);
	List<JobApply> getAlljobApply();
	boolean isjobApplyExist(int jobApplyId);
	JobApply getjobApplyById(int applyId);
	boolean deletejobApply(int jobApplyId);
	
	List<JobApply> findByJobsekerUserId(int userId);
	
	void updateStatusByUserId(int userId, String status,String finalScore, int vacancyId);
	
	List<JobApply> findByCompanyId(int companyId);
	boolean existsByVacancyIdAndUserId(int vacancyId, int userId);	
	
}
