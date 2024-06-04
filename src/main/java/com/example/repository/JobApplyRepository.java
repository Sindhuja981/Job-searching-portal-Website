package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.JobApply;

import jakarta.transaction.Transactional;

public interface JobApplyRepository extends JpaRepository<JobApply, Integer>{
	List<JobApply> findByJobsekersUserId(int userId);
	

	@Modifying
    @Transactional
    @Query("UPDATE JobApply j SET j.status = :status, j.finalscore = :finalScore WHERE j.jobsekers.userId = :userId AND j.vacancies.vacancyId = :vacancyId")
    void updateStatusAndFinalScoreByUserIdAndVacancyId(@Param("userId") int userId, @Param("vacancyId") int vacancyId, @Param("status") String status, @Param("finalScore") String finalScore);
	
	
	
	@Query(value = "SELECT * FROM JobApply WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancies WHERE company_Id = :companyId)", nativeQuery = true)
	List<JobApply> findByCompanyId(int companyId);
	
	//JobApply getJobApplyById(int applyId);
	
	@Query(value = "SELECT apply_id FROM jobapply WHERE vacancy_id = :vacancyId AND user_id = :userId", nativeQuery = true)
    List<Integer> findApplyIdByVacancyIdAndUserId(@Param("vacancyId") int vacancyId, @Param("userId") int userId);

}
