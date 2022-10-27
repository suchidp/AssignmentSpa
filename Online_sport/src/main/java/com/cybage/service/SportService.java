package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.SportDao;
import com.cybage.models.Batches;
import com.cybage.models.Sport;

@Service
public class SportService implements SportServices {

	@Autowired
	SportDao sportdao;

	
	//Add sport
	public String saveSport(Sport sport) {

		Sport sportdetails = sportdao.save(sport);
		return sportdetails.getSportName() + ", successfully registered";
	}

	
	
	//Update sport
	public Sport updateSportDetails(Sport sport, int sportId) {

		Sport sport1 = sportdao.findById(sportId).get();

		sport1.setSportName(sport1.getSportName());
		sport1.setAdm(sport1.getAdm());

		Sport sportdetails = sportdao.save(sport1);
		return sportdetails;
	}
  
	
	//Find sport by sportId
	public Sport getSportById(int sportId) {

		return sportdao.findById(sportId).get();
	}

	
	
	//Delete sport 
	public String deleteSportDetails(int sportId) {

		sportdao.deleteById(sportId);
		return "Sport details deleted successfully with id : " + sportId;
	}

	
	//List of sport
	public List<Sport> getall() {
		// TODO Auto-generated method stub
		return sportdao.findAll();
	}

	/*
	 * public List<Sport> findbyTitle(String keyword) { if (keyword != null) {
	 * return sportdao.search(keyword); } return sportdao.findAll(); }
	 */
	public List<Sport> getSportList() {
		return sportdao.getSportList();
	}

	
	//List of sport for Manager
	public List<Sport> getSportByManager(int managerId) {
		// TODO Auto-generated method stub
		return sportdao.findSportBymanagerId(managerId);
	}
}
