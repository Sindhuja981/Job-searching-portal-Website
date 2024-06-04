package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.TestResult;



@Service
public interface TestResultService {
	
	void addtestResult(TestResult testResult);
	List<TestResult> getAlltestResult();
	boolean isTestResultExist(int testResultId);
	TestResult gettestResultById(int testResultId);
	boolean deletetestResult(int testResultId);
	boolean updateTestResultById(TestResult testResult);
	List<Object[]> getScoreAndCountByResultAndUserId(int userId);
}
