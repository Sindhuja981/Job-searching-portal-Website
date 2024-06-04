package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EMail;




@RestController
public class mailController {
	
	@Autowired
	com.example.service.EmailService senderservice;
	
	@PostMapping("/sendMail")
	public ResponseEntity<Object> addCustomer(@RequestBody EMail email ){
		senderservice.sendHtmlEmail(email.getToMail(), email.getSubject(), email.getBody());
		return new ResponseEntity<>("Mail Sent.",HttpStatus.OK);		
	}

}
