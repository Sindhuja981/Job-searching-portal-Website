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


import com.example.entity.TestResult;
import com.example.service.TestResultService;

@RestController
@RequestMapping("/api/v1")
public class TestResultController {
	@Autowired
	TestResultService testService;
	
	@PostMapping(value="/AddTestResult")
	public ResponseEntity<Object> addTestResult(@RequestBody TestResult testResult){
		testService.addtestResult(testResult);
		return new ResponseEntity<>("testResult is added", HttpStatus.CREATED);	
	}
	@GetMapping(value="/AllTestResult")
	public ResponseEntity<Object> getAllTestResult(){
		List<TestResult> test = testService.getAlltestResult();
		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteTestResult/{testResultId}")
	public ResponseEntity<Object> deletetestResult(@PathVariable("testResultId") int testResultId){
		boolean flag;
		if(testService.deletetestResult(testResultId)) {
			flag = testService.deletetestResult(testResultId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getTestResult/{testResultId}")
    public ResponseEntity<Object> getTestResultById(@PathVariable("testResultId") int testResultId) {
		TestResult testResult = testService.gettestResultById(testResultId);
        if (testResult != null) {
            return new ResponseEntity<>(testResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Questions not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updatetestService/{testResultId}")
	public ResponseEntity<Object> updateQuestionId(@PathVariable("testResultId") int testResultId, @RequestBody TestResult testResult)
	{
		boolean flag;
		if(testService.isTestResultExist(testResultId)) {
			flag = testService.updateTestResultById(testResult);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping("/getResultsOfUser/{userId}")
	public ResponseEntity<Object> getResult(@PathVariable("userId")int userId) {
		List<Object[]> testresult = testService.getScoreAndCountByResultAndUserId(userId);
		ResponseEntity<Object> entity = new ResponseEntity<>(testresult, HttpStatus.OK);
		return entity;
	}

}
