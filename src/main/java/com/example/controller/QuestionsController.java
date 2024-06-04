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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JobSekers;
import com.example.entity.Questions;
import com.example.service.QuestuionsService;

@RestController
@RequestMapping("/api/v1")
public class QuestionsController {
	
	@Autowired
	QuestuionsService questionService;
	
	@PostMapping(value="/AddQuestion")
	public ResponseEntity<Object> addQuestion(@RequestBody Questions question){
		questionService.addQuestion(question);
		return new ResponseEntity<>("Questions is added", HttpStatus.CREATED);	
	}
	@GetMapping(value="/AllQuestions")
	public ResponseEntity<Object> getAllQuestions(){
		List<Questions> questions = questionService.getAllQuestions();
		ResponseEntity<Object> entity = new ResponseEntity<>(questions, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteQuestions/{questionId}")
	public ResponseEntity<Object> deleteQuestions(@PathVariable("questionId") int questionId){
		boolean flag;
		if(questionService.deleteQuestions(questionId)) {
			flag = questionService.deleteQuestions(questionId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getQuestions/{questionId}")
    public ResponseEntity<Object> getQuestionsById(@PathVariable("questionId") int questionId) {
		Questions questions = questionService.getQuestionsById(questionId);
        if (questions != null) {
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Questions not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updateQuestion/{questionId}")
	public ResponseEntity<Object> updateQuestionId(@PathVariable("questionId") int questionId, @RequestBody Questions questions)
	{
		boolean flag;
		if(questionService.isQuestionsExist(questionId)) {
			flag = questionService.updateQuestionId(questions);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping(value = "/getQuestionById/{companyId}")
    public ResponseEntity<Object> findByCompanyId(@PathVariable("companyId") int companyId) {
		List<Questions> questions = questionService.findByCompanyIdQuestionId(companyId);
		System.out.println("TestList:::::"+ questions);
        if (questions != null) {
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }
	@GetMapping(value = "/getVacancyQuestionById/{vacancyId}")
    public ResponseEntity<Object> findByVacanciesCompanyId(@PathVariable("vacancyId") int vacancyId) {
		List<Questions> questions = questionService.findByVacancy_VacancyId(vacancyId);
		System.out.println("TestList:::::"+ questions);
        if (questions != null) {
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("test not found", HttpStatus.NOT_FOUND);
        }
    }

}
