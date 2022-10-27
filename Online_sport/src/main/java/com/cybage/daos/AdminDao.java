package com.cybage.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;

import com.cybage.models.Sport;

public interface AdminDao extends JpaRepository<Admin, Integer> {


	@Query("select a from Admin a where a.email =:email and a.password =:password")
	public Admin findAdminByEmailAndPassword(String email, String password);

}
