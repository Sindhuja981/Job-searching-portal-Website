package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Admin;



@Service
public interface AdminService {
	
	void addadmin(Admin admin);
	List<Admin> getAllAdmin();
	boolean isAdminExist(int adminId);
	Admin getAdminById(int adminId);
	boolean deleteAdmin(int adminId);
	boolean updateAdminId(Admin admin);
	boolean loginValidate(Admin admin);
	
	

}
