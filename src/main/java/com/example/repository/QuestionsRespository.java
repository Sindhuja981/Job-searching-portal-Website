package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Questions;

public interface QuestionsRespository extends JpaRepository<Questions, Integer>{
	
	
	 /*@Query("SELECT * FROM questions WHERE vacancy_Id IN (SELECT vacancyId FROM Vacancies  WHERE companyId = :companyId)" , nativeQuery = true)
	    List<Questions> findQuestionsByCompanyId(int companyId);*/
	   /* @Query(value = "SELECT * FROM questions WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancies WHERE company_Id = :company_Id)", nativeQuery = true)
	List<Questions> findByCompanyId(int companyId);*/
	    
	    @Query(value = "SELECT * FROM questions WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancies WHERE company_Id = :companyId)", nativeQuery = true)
		List<Questions> findByCompanyId(int companyId);
	    
	    @Query(value = "SELECT * FROM questions q WHERE q.vacancy_id = :vacancyId", nativeQuery = true)
	    List<Questions> findByVacancy_VacancyId(int vacancyId);
}
