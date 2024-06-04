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

import com.example.entity.Questions;
import com.example.entity.Test;
import com.example.entity.TestResult;
import com.example.service.TestServices;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	
	@Autowired
	TestServices testServices;
	
	@PostMapping(value="/AddTest")
	public ResponseEntity<Object> addTest(@RequestBody Test test){
		testServices.addTest(test);
		return new ResponseEntity<>("Test is added succefulley", HttpStatus.CREATED);
		
	}
	@GetMapping(value="/Alltest")
	public ResponseEntity<Object> getAlltest(){
		List<Test> test = testServices.getAllTest();
		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteTest/{testId}")
	public ResponseEntity<Object> deleteTest(@PathVariable("testId") int testId){
		boolean flag;
		if(testServices.deleteTest(testId)) {
			flag = testServices.deleteTest(testId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/gettests/{testId}")
    public ResponseEntity<Object> getTestById(@PathVariable("testId") int testId) {
		Test test = testServices.getTestById(testId);
        if (test != null) {
            return new ResponseEntity<>(test, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updateTest/{testId}")
	public ResponseEntity<Object> updateTestId(@PathVariable("testId") int testId, @RequestBody Test test)
	{
		boolean flag;
		if(testServices.isTestExist(testId)) {
			flag = testServices.updateTestId(test);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping(value = "/getCompanyId/{companyId}")
    public ResponseEntity<Object> getTestByCompanyId(@PathVariable("companyId") int companyId) {
		 List<Test> test = testServices.findByCompanyId(companyId);
        if (test != null) {
            return new ResponseEntity<>(test, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping(value = "/getTestId/{companyId}")
    public ResponseEntity<Object> findTestIdsByCompanyId(@PathVariable("companyId") int companyId) {
		List<Test> test = testServices.findByCompanyId(companyId);
		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
	}
	@GetMapping(value = "/gettestbyvacancyId/{vacancyId}")
    public ResponseEntity<Object> getTestById1(@PathVariable("vacancyId") int vacancyId) {
		Test test = testServices.findByVacancyId(vacancyId);
		ResponseEntity<Object> entity = new ResponseEntity<>(test,HttpStatus.OK);
		return entity;
       
    }
	
	

}
