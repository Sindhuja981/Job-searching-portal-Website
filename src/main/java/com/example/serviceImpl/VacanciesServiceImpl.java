package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Vacancies;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.VancanciesRepository;
import com.example.service.VacanciesServices;

@Service
public class VacanciesServiceImpl implements VacanciesServices{
	
	@Autowired
	VancanciesRepository vancanciesRepository;

	@Override
	public void addVacancies(Vacancies vacancies) {
		// TODO Auto-generated method stub
		vancanciesRepository.save(vacancies);
		
	}

	@Override
	public List<Vacancies> getAllVacancies() {
		// TODO Auto-generated method stub
		List<Vacancies> list = vancanciesRepository.findAll();
		return list;
	}

	@Override
	public boolean isVacanciesExist(int vacancyId) {
		// TODO Auto-generated method stub
		Optional<Vacancies> vacancies = vancanciesRepository.findById(vacancyId);
		Vacancies vacanciess;
		if(vacancies.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Vacancies getVacanciesById(int vacancyId) {
		// TODO Auto-generated method stub
		Optional<Vacancies> vacancies = vancanciesRepository.findById(vacancyId);
		Vacancies Vacanciess;
		if(vacancies.isPresent()) {
			Vacanciess = vacancies.get();
		}else {
			throw new ResourceNotFoundException("Vacancies","vacancyId", vacancyId);
		}
		return Vacanciess;
	}

	@Override
	public boolean deleteVacancies(int vacancyId) {
		// TODO Auto-generated method stub
		Optional<Vacancies> test = vancanciesRepository.findById(vacancyId);
		Vacancies tests;
		if(test.isPresent()) {
			vancanciesRepository.deleteById(vacancyId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateVacanciesId(Vacancies vacancies) {
		// TODO Auto-generated method stub
		Optional<Vacancies> vacanciess = vancanciesRepository.findById(vacancies.getVacancyId());
		Vacancies vacanciesss;
		if(vacanciess.isPresent()) {
			vancanciesRepository.save(vacancies);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Vacancies> findByCompanyByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		List<Vacancies> list = vancanciesRepository.findByCompany_CompanyId(companyId);
		return list;
	}

	@Override
	public List<Object[]> findVacancyIdAndJobTitleByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		List<Object[]> list = vancanciesRepository.findVacancyIdAndJobTitleByCompanyId(companyId);
		return list;
	}

	
	

	

	
	

}
