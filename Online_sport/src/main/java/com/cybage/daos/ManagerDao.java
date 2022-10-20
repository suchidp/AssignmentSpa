package com.cybage.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;
import com.cybage.models.Manager;


public interface ManagerDao extends JpaRepository<Manager, Integer>{
	@Transactional
	@Modifying
	@Query("select a from Manager a where a.managerId=:managerId")
	public Manager getManagerById(int managerId);
	//public Player savePlayer (Player player);
	
	@Query("select a from Manager a where a.email =:email and a.password =:password")
	public Manager findManagerByEmailAndPassword(String email, String password);
	
	@Query("select u from Manager u")
	public List<Manager> getManager();
}
