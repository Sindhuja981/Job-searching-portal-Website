package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Vacancies;


public interface VancanciesRepository extends JpaRepository<Vacancies, Integer>{
	
	List<Vacancies> findByCompany_CompanyId(int companyId);
	
	 @Query("SELECT v.vacancyId, v.jobTitle FROM Vacancies v WHERE v.company.companyId = :companyId")
	    List<Object[]> findVacancyIdAndJobTitleByCompanyId(int companyId);

}
