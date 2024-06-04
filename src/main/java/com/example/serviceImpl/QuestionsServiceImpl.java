package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobSekers;
import com.example.entity.Questions;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.QuestionsRespository;
import com.example.service.QuestuionsService;

@Service
public class QuestionsServiceImpl implements QuestuionsService {
	
	@Autowired
	QuestionsRespository questionRespository;

	@Override
	public void addQuestion(Questions question) {
		// TODO Auto-generated method stub
		questionRespository.save(question);
		
	}

	@Override
	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Questions> list = questionRespository.findAll();
		return list;
	}

	@Override
	public boolean isQuestionsExist(int questionId) {
		// TODO Auto-generated method stub
		Optional<Questions> questions = questionRespository.findById(questionId);
		Questions questionss;
		if(questions.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Questions getQuestionsById(int questionId) {
		// TODO Auto-generated method stub
		Optional<Questions> questions = questionRespository.findById(questionId);
		Questions questionss;
		if(questions.isPresent()) {
			questionss = questions.get();
		}else {
			throw new ResourceNotFoundException("Questions","questionId", questionId);
		}
		return questionss;
	}

	@Override
	public boolean deleteQuestions(int questionId) {
		// TODO Auto-generated method stub
		Optional<Questions> questions = questionRespository.findById(questionId);
		Questions questionss;
		if(questions.isPresent()) {
			questionRespository.deleteById(questionId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateQuestionId(Questions question) {
		// TODO Auto-generated method stub
		Optional<Questions> questions = questionRespository.findById(question.getQuestionId());
		Questions questionss;
		if(questions.isPresent()) {
			questionRespository.save(question);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public List<Questions> findByCompanyIdQuestionId(int companyId) {
		// TODO Auto-generated method stub
		List<Questions> list = questionRespository.findByCompanyId(companyId);
		return list;
	}

	@Override
	public List<Questions> findByVacancy_VacancyId(int vacancyId) {
		// TODO Auto-generated method stub
		List<Questions> list = questionRespository.findByVacancy_VacancyId(vacancyId);
		return list;
	}

	


}
