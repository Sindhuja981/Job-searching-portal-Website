package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.entity.Vacancies;

@Service
public interface VacanciesServices {
	void addVacancies(Vacancies vacancies);
	List<Vacancies> getAllVacancies();
	boolean isVacanciesExist(int vacancyId);
	Vacancies getVacanciesById(int vacancyId);
	boolean deleteVacancies(int vacancyId);
	boolean updateVacanciesId(Vacancies vacancies);
	List<Vacancies> findByCompanyByCompanyId(int companyId);
	List<Object[]> findVacancyIdAndJobTitleByCompanyId(int companyId);
}
