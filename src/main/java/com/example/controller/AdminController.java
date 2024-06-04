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


import com.example.entity.Admin;
import com.example.service.AdminService;

@RestController
@RequestMapping("/api/v1")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping(value="/AddAdmin")
	public ResponseEntity<Object> addadmin(@RequestBody Admin admin){
		adminService.addadmin(admin);
		return new ResponseEntity<>("Admin added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(value="/alladmins")
	public ResponseEntity<Object> getAllAdmin(){
		List<Admin> products = adminService.getAllAdmin();
		ResponseEntity<Object> entity = new ResponseEntity<>(products, HttpStatus.OK);
		return entity;
		
	}
	@DeleteMapping(value = "/deleteAdmin/{adminId}")
	public ResponseEntity<Object> deleteAdmin(@PathVariable("adminId") int adminId){
		boolean flag;
		if(adminService.isAdminExist(adminId)) {
			flag = adminService.deleteAdmin(adminId);
		}else {
			flag = false;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@GetMapping(value = "/getAdmin/{adminId}")
    public ResponseEntity<Object> getProduct(@PathVariable("adminId") int adminId) {
        Admin admin = adminService.getAdminById(adminId);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Admin not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping(value="/updateAdmin/{adminId}")
	public ResponseEntity<Object> updateAdminId(@PathVariable("adminId") int adminId, @RequestBody Admin admin)
	{
		boolean flag;
		if(adminService.isAdminExist(adminId)) {
			flag = adminService.updateAdminId(admin);
		}else {
			flag = false;
		}		
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}
	@PostMapping(value="/adminLogin")
	public  ResponseEntity<Object> adminLogin(@RequestBody Admin admin){
		boolean flag = adminService.loginValidate(admin);
		return new ResponseEntity<>(flag,HttpStatus.OK);
	}
}
