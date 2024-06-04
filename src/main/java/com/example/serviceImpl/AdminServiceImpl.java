package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Admin;
import com.example.execption.ResourceNotFoundException;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public void addadmin(Admin admin) {
		// TODO Auto-generated method stub
		adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		List<Admin> list = adminRepository.findAll();
		return list;
	}


	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepository.findById(adminId);
		Admin admins;
		if(admin.isPresent()) {
			admins = admin.get();
		}else {
			throw new ResourceNotFoundException("Admin","adminId", adminId);
		}
		return admins;
		
	}

	

	@Override
	public boolean updateAdminId(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> admin1 = adminRepository.findById(admin.getAdminId());
		Admin admins;
		if(admin1.isPresent()) {
			adminRepository.save(admin);
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean loginValidate(Admin admin) {
		// TODO Auto-generated method stub
		Admin admin1 = adminRepository.findByUserNameAndPassword(admin.getUserName(), admin.getPassword());
		 if(admin1==null) 
			 return false;
		 else 
		return true;
	}

	@Override
	public boolean isAdminExist(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminRepository.findById(adminId);
		Admin admins;
		if(admin.isPresent()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admin1 = adminRepository.findById(adminId);
		Admin admins;
		if(admin1.isPresent()) {
			adminRepository.deleteById(adminId);
			return true;
		}else {
			return false;
		}
	}

}
