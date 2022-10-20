package com.cybage.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;
import com.cybage.models.Batches;
import com.cybage.models.Sport;





public interface SportDao extends JpaRepository<Sport, Integer> {
	@Query("select u from Sport u")
	public List<Sport> getSportList();
   
	public Sport save(Sport sport);
	/*
	@Query("SELECT p FROM Sport p WHERE CONCAT(p.name ,p.description) LIKE %?1%")
	List<Sport> search(String keyword);*/
	
	@Query(value="select * from Sport c join manager d on c.manager_id=:managerId and d.manager_id=:managerId",nativeQuery = true)
	public List<Sport> findSportBymanagerId(int managerId);
	
	
	@Query("select a from Sport a where a.sportId=:sportId")
	public Sport getSportById(int sportId);
}
