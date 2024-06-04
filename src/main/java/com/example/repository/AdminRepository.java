package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
	public Admin findByUserNameAndPassword(String userName, String password);


}
