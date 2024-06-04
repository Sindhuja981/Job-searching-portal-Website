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


import com.example.entity.Vacancies;
import com.example.service.VacanciesServices;

@RestController
@RequestMapping("/api/v1")
public class VancanciesController {
	
	@Autowired
	VacanciesServices vacanciesServices;
	
	@PostMapping(value="/AddVacancies")
	public ResponseEntity<Object> addVacancies(@RequestBody Vacancies vacancies){
		vacanciesServices.addVacancies(vacancies);
		return new ResponseEntity<>("vacancies added successfully", HttpStatus.CREATED);
		
	}
	@GetMapping(value="/Allvacancies")
	public ResponseEntity<Object> getAllVacancies(){
		List<Vacancies> vacancies = vacanciesServices.getAllVacancies();
		ResponseEntity<Object> entity = new ResponseEntity<>(vacancies, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deletevacancy/{vacancyId}")
	public ResponseEntity<Object> deletevacancy(@PathVariable("vacancyId") int vacancyId){
		boolean flag;
		if(vacanciesServices.deleteVacancies(vacancyId)) {
			flag = vacanciesServices.deleteVacancies(vacancyId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/getvacancy/{vacancyId}")
    public ResponseEntity<Object> getvacancyById(@PathVariable("vacancyId") int vacancyId) {
		Vacancies vacancies = vacanciesServices.getVacanciesById(vacancyId);
        if (vacancies != null) {
            return new ResponseEntity<>(vacancies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updatevacancy/{vacancyId}")
	public ResponseEntity<Object> updatevacancy(@PathVariable("vacancyId") int vacancyId, @RequestBody Vacancies vacancies)
	{
		boolean flag;
		if(vacanciesServices.isVacanciesExist(vacancyId)) {
			flag = vacanciesServices.updateVacanciesId(vacancies);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping(value="/getvacancyCid/{companyId}")
	public ResponseEntity<Object> getvacancyBycompanyId(@PathVariable("companyId") int companyId) {
		List<Vacancies> vacancies = vacanciesServices.findByCompanyByCompanyId(companyId);
        if (vacancies != null) {
            return new ResponseEntity<>(vacancies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping(value="/vacancyIdAndJobtitle/{companyId}")
	public ResponseEntity<Object> getAllVacanciesIds(@PathVariable("companyId") int companyId){
		List<Object[]> vacancy = vacanciesServices.findVacancyIdAndJobTitleByCompanyId(companyId);
		ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
		return entity;
	}
	
	
	

}
