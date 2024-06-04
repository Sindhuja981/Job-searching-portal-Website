package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.entity.SelectedCandidates;
import com.example.entity.Test;
import com.example.service.SelectedCandidatesService;

@Controller
@RequestMapping("api/v1")
public class SeletedCandidatesController {
	
	@Autowired
	SelectedCandidatesService selserv;
	
	
	@PostMapping(value="/addSelectedCan")
	public ResponseEntity<Object> addcompany(@RequestBody SelectedCandidates selectedCandidates ){
		selserv.addSelectedCandidates(selectedCandidates);
		return new ResponseEntity<>("selectedCandidates added successfully", HttpStatus.CREATED);
	}
	@GetMapping(value="/AllselectedCandidates")
	public ResponseEntity<Object> getAlltest(){
		List<SelectedCandidates> test = selserv.getAllSelectedCandidates();
		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
		
	}
	
	
	
}
