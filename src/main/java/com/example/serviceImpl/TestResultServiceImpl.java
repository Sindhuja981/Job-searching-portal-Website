package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Questions;
import com.example.entity.TestResult;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.TestResultRepository;
import com.example.service.TestResultService;

@Service
public class TestResultServiceImpl implements TestResultService{
	
	@Autowired
	TestResultRepository testResultRepository;

	@Override
	public void addtestResult(TestResult testResult) {
		// TODO Auto-generated method stub
		testResultRepository.save(testResult);
		
	}

	@Override
	public List<TestResult> getAlltestResult() {
		// TODO Auto-generated method stub
		List<TestResult> list = testResultRepository.findAll();
		return list;
	}

	@Override
	public boolean isTestResultExist(int testResultId) {
		// TODO Auto-generated method stub
		Optional<TestResult> test = testResultRepository.findById(testResultId);
		TestResult testresults;
		if(test.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public TestResult gettestResultById(int testResultId) {
		// TODO Auto-generated method stub
		Optional<TestResult> test = testResultRepository.findById(testResultId);
		TestResult testresults;
		if(test.isPresent()) {
			testresults = test.get();
		}else {
			throw new ResourceNotFoundException("Questions","questionId", testResultId);
		}
		return testresults;
	}

	@Override
	public boolean deletetestResult(int testResultId) {
		// TODO Auto-generated method stub
		Optional<TestResult> test = testResultRepository.findById(testResultId);
		TestResult testresults;
		if(test.isPresent()) {
			testResultRepository.deleteById(testResultId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateTestResultById(TestResult testResult) {
		// TODO Auto-generated method stub
		Optional<TestResult> test = testResultRepository.findById(testResult.getTestResultId());
		TestResult testresults;
		if(test.isPresent()) {
			testResultRepository.save(testResult);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Object[]> getScoreAndCountByResultAndUserId(int userId) {
		// TODO Auto-generated method stub
		List<Object[]> list = testResultRepository.getScoreAndCountByResultAndUserId(userId);
		return list;
	}

}
