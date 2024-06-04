package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Company;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.CompanyRepository;
import com.example.service.CompanyService;

@Service
public class companyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public void addcompany(Company Company) {
		// TODO Auto-generated method stub
		companyRepository.save(Company);
		
	}

	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		List<Company> list = companyRepository.findAll();
		return list;
	
	}

	@Override
	public boolean isCompanyExist(int companyId) {
		// TODO Auto-generated method stub
		Optional<Company> Company = companyRepository.findById(companyId);
		Company companys;
		if(Company.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Company getCompanyById(int companyId) {
		// TODO Auto-generated method stub
		Optional<Company> Company = companyRepository.findById(companyId);
		Company Companys;
		if(Company.isPresent()) {
			Companys = Company.get();
		}else {
			throw new ResourceNotFoundException("Company","companyId", companyId);
		}
		return Companys;
	}

	@Override
	public boolean deletecompany(int companyId) {
		// TODO Auto-generated method stub
		Optional<Company> Company = companyRepository.findById(companyId);
		Company Companys;
		if(Company.isPresent()) {
			companyRepository.deleteById(companyId);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean updateCompanyId(Company Company) {
		// TODO Auto-generated method stub
		Optional<Company> Companys = companyRepository.findById(Company.getCompanyId());
		Company Companyes;
		if(Companys.isPresent()) {
			companyRepository.save(Company);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public Company loginValidate(String email) {
		// TODO Auto-generated method stub
		Company Companys = companyRepository.findByEmail(email);
		return Companys;
	}

	/*@Override
	public company loginValidate(comapny Company) {
		// TODO Auto-generated method stub
		company Companys = companyRepository.findByEmail(Company);
		System.out.println("what is there in company="+Companys); 
		return Companys;
	}*/
	

}



