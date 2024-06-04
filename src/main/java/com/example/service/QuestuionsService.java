package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.entity.Questions;

@Service
public interface QuestuionsService {
	void addQuestion(Questions question);
	List<Questions> getAllQuestions();
	boolean isQuestionsExist(int questionId);
	Questions getQuestionsById(int questionId);
	boolean deleteQuestions(int questionId);
	boolean updateQuestionId(Questions question);
	List<Questions> findByCompanyIdQuestionId(int companyId);
	List<Questions> findByVacancy_VacancyId(int vacancyId);

}
