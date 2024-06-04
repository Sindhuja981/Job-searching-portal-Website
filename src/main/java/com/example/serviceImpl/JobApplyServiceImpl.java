package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobApply;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.JobApplyRepository;
import com.example.service.JobApplyService;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

@Service
public class JobApplyServiceImpl implements JobApplyService{
	@Autowired
	JobApplyRepository jobApplyRe;

	@Override
	public void addjobApply(JobApply jobApply) {
		// TODO Auto-generated method stub
		jobApplyRe.save(jobApply);
	}

	@Override
	public List<JobApply> getAlljobApply() {
		// TODO Auto-generated method stub
		List<JobApply> list = jobApplyRe.findAll();
		return list;
	}

	@Override
	public boolean isjobApplyExist(int jobApplyId) {
		// TODO Auto-generated method stub
		Optional<JobApply> job = jobApplyRe.findById(jobApplyId);
		JobApply jobapply;
		if(job.isPresent()) {
			return true;		
		}else {
		return false;
		}
	}

	@Override
	public JobApply getjobApplyById(int applyId) {
		// TODO Auto-generated method stub
		Optional<JobApply> job = jobApplyRe.findById(applyId);
		JobApply jobapply;
		if(job.isPresent()) {
			jobapply=job.get();
		}else {
			throw new ResourceNotFoundException("JobApply","applyId",applyId); 
			
		}
		return jobapply;
	}

	@Override
	public boolean deletejobApply(int jobApplyId) {
		// TODO Auto-generated method stub
		Optional<JobApply> job = jobApplyRe.findById(jobApplyId);
		JobApply jobapply;
		if(job.isPresent()) {
			jobApplyRe.deleteById(jobApplyId);
			return true;
		}

		return false;
	}

	

	@Override
	public List<JobApply> findByJobsekerUserId(int userId) {
		List<JobApply> list = jobApplyRe.findByJobsekersUserId(userId);
		return list;
	}

	@Override
	@Transactional
	public void updateStatusByUserId(int userId, String status, String finalScore, int vacancyId) {
		// TODO Auto-generated method stub
		jobApplyRe.updateStatusAndFinalScoreByUserIdAndVacancyId(userId, vacancyId, status, finalScore);
	}

	@Override
	public List<JobApply> findByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		List<JobApply> list = jobApplyRe.findByCompanyId(companyId);
		return list;
	}

	@Override
	public boolean existsByVacancyIdAndUserId(int vacancyId, int userId) {
		// TODO Auto-generated method stub
		List<Integer> applyIds = jobApplyRe.findApplyIdByVacancyIdAndUserId(vacancyId, userId);
	    if (!applyIds.isEmpty()) {
	        return true; // User has applied for this vacancy
	    } else {
	        return false; // User has not applied for this vacancy
	    }
	}


	
	/*@Override
	public List<JobApply> findByJobsekersUserId(int jobApplyId) {
		// TODO Auto-generated method stub
		List<JobApply> list = jobApplyRe.findByJobsekersUserId(jobApplyId);
		
		
		return list;
	}*/

}
