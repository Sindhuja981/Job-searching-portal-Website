package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.entity.Company;

@Service
public interface CompanyService {
	void addcompany(Company Company);
	List<Company> getAllCompany();
	boolean isCompanyExist(int companyId);
	Company getCompanyById(int companyId);
	boolean deletecompany(int companyId);
	boolean updateCompanyId(Company Company);
	Company loginValidate(String email);

}
