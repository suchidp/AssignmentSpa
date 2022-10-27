package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.ManagerDao;
import com.cybage.models.Admin;
import com.cybage.models.Manager;

import com.cybage.models.Sport;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerdao;
	
	
	// Create credentials of  Manager by admin
	public Manager saveManager(Manager manager) {

		return managerdao.save(manager);
	}
  
	
	//Login Manager
	public Manager findManagerByEmailAndPassword(String email, String password) {
		return managerdao.findManagerByEmailAndPassword(email, password);
	}

	
	//Find manager by id
	public Manager getManagertById(int managerId) {

		return managerdao.findById(managerId).get();
	}

	
	//List of manager
	public List<Manager> getall() {
		// TODO Auto-generated method stub
		return managerdao.findAll();
	}

	
	//Registration of Manager
	public Manager registerManager(Manager manager) {
		return managerdao.save(manager);

	}
}
