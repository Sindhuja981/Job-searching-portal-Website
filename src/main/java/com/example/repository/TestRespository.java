package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Test;

public interface TestRespository extends JpaRepository<Test,Integer>{
	@Query(value = "SELECT * FROM test WHERE vacancy_Id IN (SELECT vacancy_Id FROM Vacancies WHERE company_Id = :companyId)", nativeQuery = true)
    List<Test> findByCompanyId(int companyId);
	
	  @Query(value = "SELECT test_Id FROM test WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancies WHERE company_Id = :companyId)", nativeQuery = true)
	    List<Integer> findTestIdsByCompanyId(int companyId);
	
	/*@Query("SELECT test_Id FROM Test t WHERE t.vacancyId IN (SELECT v.vacancyId FROM Vacancies v WHERE v.companyId = ?1)")
    Test findTestIdsByCompanyId(int companyId);*/
	  
	  Test findOneByVacancies_VacancyId(int vacancyId);
 
}
