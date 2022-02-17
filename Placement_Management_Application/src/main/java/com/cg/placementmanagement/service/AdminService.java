package com.cg.placementmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanagement.model.Admin;
import com.cg.placementmanagement.repository.AdminRepository;



@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repo;
  
  public Admin login(String username, String password) {
	  Admin user = repo.findByUsernameAndPassword(username, password);
  	return user;
  }
	

}