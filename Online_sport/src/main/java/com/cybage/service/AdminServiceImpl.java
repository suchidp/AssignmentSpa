package com.cybage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.AdminDao;

import com.cybage.models.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminDao admindao;

	
	//Login of Admin
	public Admin findAdminByEmailAndPassword(String email, String password) {
		return admindao.findAdminByEmailAndPassword(email, password);
	}

	
	// Registation of Admin 
	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return admindao.save(admin);
	}
}
