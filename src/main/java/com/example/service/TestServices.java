package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.entity.Test;

@Service
public interface TestServices {
	void addTest(Test test);
	List<Test> getAllTest();
	boolean isTestExist(int testId);
	Test getTestById(int testId);
	boolean deleteTest(int testId);
	boolean updateTestId(Test test);
	List<Test> findByCompanyId(int companyId);
	List<Integer> findTestIdsByCompanyId(int companyId);
	 Test findByVacancyId(int vacancyId);
}
