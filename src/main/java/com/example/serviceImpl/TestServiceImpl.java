package com.example.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Questions;
import com.example.entity.Test;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.TestRespository;
import com.example.service.TestServices;

@Service
public class TestServiceImpl implements TestServices{
	
	@Autowired
	TestRespository testRespository;

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		testRespository.save(test);
		
		
	}

	@Override
	public List<Test> getAllTest() {
		// TODO Auto-generated method stub
		List<Test> list = testRespository.findAll();
		return list;
	}

	@Override
	public boolean isTestExist(int testId) {
		// TODO Auto-generated method stub
		Optional<Test> test = testRespository.findById(testId);
		Test tests;
		if(test.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Test getTestById(int testId) {
		// TODO Auto-generated method stub
		Optional<Test> test = testRespository.findById(testId);
		Test tests;
		if(test.isPresent()) {
			tests = test.get();
		}else {
			throw new ResourceNotFoundException("Test","testId", testId);
		}
		return tests;
	}

	@Override
	public boolean deleteTest(int testId) {
		// TODO Auto-generated method stub
		Optional<Test> test = testRespository.findById(testId);
		Test tests;
		if(test.isPresent()) {
			testRespository.deleteById(testId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateTestId(Test test) {
		// TODO Auto-generated method stub
		Optional<Test> tests = testRespository.findById(test.getTestId());
		Test testss;
		if(tests.isPresent()) {
			testRespository.save(test);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Test> findByCompanyId(int companyId) {
		// TODO Auto-generated method stub
				
				
				List<Test> list=testRespository.findByCompanyId(companyId);
				 if (list.isEmpty()) {
			            return Collections.emptyList(); // Return empty list if no tests are found
			        }
			        
			        return list;
			    }
				
	

	@Override
	public List<Integer> findTestIdsByCompanyId(int companyId) {
		// TODO Auto-generated method stub
		List<Integer> list = testRespository.findTestIdsByCompanyId(companyId);
		return list;
	}

	@Override
	public Test findByVacancyId(int vacancyId) {
		// TODO Auto-generated method stub
		Test test = testRespository.findOneByVacancies_VacancyId(vacancyId);
		return test;
	} 

}
