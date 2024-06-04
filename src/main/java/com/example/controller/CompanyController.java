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


import com.example.entity.Company;
import com.example.service.CompanyService;

@RestController
@RequestMapping("/api/v1")
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	
	@PostMapping(value="/AddCompany")
	public ResponseEntity<Object> addcompany(@RequestBody Company Company ){
		companyservice.addcompany(Company);
		return new ResponseEntity<>("Company added successfully", HttpStatus.CREATED);
	}
	@GetMapping(value="/allCompanys")
	public ResponseEntity<Object> getAllCompany(){
		List<Company> Company = companyservice.getAllCompany();
		ResponseEntity<Object> entity = new ResponseEntity<>(Company, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteCompany/{companyId}")
	public ResponseEntity<Object> deletecompany(@PathVariable("companyId") int companyId){
		boolean flag;
		if(companyservice.deletecompany(companyId)) {
			flag = companyservice.deletecompany(companyId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getCompany/{companyId}")
    public ResponseEntity<Object> getCompanyById(@PathVariable("companyId") int companyId) {
        Company Company = companyservice.getCompanyById(companyId);
        if (Company != null) {
            return new ResponseEntity<>(Company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updateCompany/{companyId}")
	public ResponseEntity<Object> updateCompanyId(@PathVariable("companyId") int companyId, @RequestBody Company Company)
	{
		boolean flag;
		if(companyservice.isCompanyExist(companyId)) {
			flag = companyservice.updateCompanyId(Company);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@GetMapping(value="/CompanyLogin/{email}")
	public  ResponseEntity<Object> loginValidate(@PathVariable("email") String email){
		Company flag = companyservice.loginValidate(email);
		return new ResponseEntity<>(flag,HttpStatus.OK);
	}

}
