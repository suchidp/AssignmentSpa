package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.PlayerSubscriptionDao;
import com.cybage.models.Batches;
import com.cybage.models.EnrollmentStatus;
import com.cybage.models.PlayerSubscription;
import com.cybage.models.Sport;



@Service
public class PlayerSubscriptionService {
	@Autowired
	PlayerSubscriptionDao playersubscriptionDao ;
	
	public String selectSubscription(PlayerSubscription playersubscription) {
		PlayerSubscription selectSubscription = playersubscriptionDao.save(playersubscription);
		return selectSubscription.getPlayerSubscriptionId()
				+",sucessfully added with id : "
				 +selectSubscription.getPlayerSubscriptionId();
	}
	
public  PlayerSubscription getSubscriptionById(int playerSubscriptionId) {
		
		return playersubscriptionDao.findById(playerSubscriptionId).get();
	}

public List<PlayerSubscription> findPlayersubscriptionBymanagerId(int managerId) {
	// TODO Auto-generated method stub
	return playersubscriptionDao.findPlayerSubscriptionBymanagerId(managerId);
}
	
	
	
public String deletePlayersubscription(int playerSubscriptionId) {
		
	playersubscriptionDao.deleteById(playerSubscriptionId);
		return " deleted successfully with id : "+playerSubscriptionId;
	}

	public List<PlayerSubscription> getPlayersubscription() {
		// TODO Auto-generated method stub
		return 	playersubscriptionDao.findAll();
	}

	public List<PlayerSubscription> findByPlayer(int playerId) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findByPlayer(playerId);
	}
	
	public List<PlayerSubscription> findPendingPlayersubscriptionByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findPendingPlayerSubscriptionByManagerId(managerId);
	}

	;
	public List<PlayerSubscription> findNewPlayersubscriptionByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findNewPlayerSubscriptionByManagerId(managerId);
	}
	public List<PlayerSubscription> findCompletedPlayersubscriptionByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findCompletedPlayerSubscriptionByManagerId(managerId);
	}
	public List<PlayerSubscription> findRenewPlayersubscriptionByManagerId(int managerId) {
		// TODO Auto-generated method stub
		return playersubscriptionDao.findRenewPlayerSubscriptionByManagerId(managerId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object acceptPlayersubscription(int playerSubscriptionId) {
		// TODO Auto-generated method stub
		PlayerSubscription playersubscription = playersubscriptionDao.findById(playerSubscriptionId).get();
		if( playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.APPLIED)) {
			playersubscription.setEnrollmentstatus(EnrollmentStatus.INPROGRESS);
			 playersubscriptionDao.save(playersubscription);
		return "Playersubscription Accepted !!!";
		}else if(playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.INPROGRESS)) {
			return "Playersubscription already accepted!!!";
		}else if(playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.INPROGRESS) || playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.APPROVE)) {
			return "Playersubscription already Processed !!!";
		}else {
		return "Playersubscription already declined  batch is full!!!";
		}
			}

	
	
	
	
	
	

	public Object rejectPlayersubscription(int playerSubscriptionId) {
		PlayerSubscription playersubscription = playersubscriptionDao.findById(playerSubscriptionId).get();

		if (playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.APPLIED)){
			 playersubscription.setEnrollmentstatus(EnrollmentStatus.REJECT);
			 playersubscriptionDao.save(playersubscription);
		return "Playersubscription is rejected because batch is full ,we will get back to you!!!";
		}else {
			return "Playersubscription already Aceepeted ";
		}
	}


	public Object completePlayersubscription(int playerSubscriptionId) {
		// TODO Auto-generated method stub
		PlayerSubscription playersubscription = playersubscriptionDao.findById(playerSubscriptionId).get();

		
		if (playersubscription.getEnrollmentstatus().equals(EnrollmentStatus.INPROGRESS)){
			if(playersubscription.getEnrollmentstatus()!=EnrollmentStatus.REJECT) {
				playersubscription.setEnrollmentstatus(EnrollmentStatus.APPROVE);
				 playersubscriptionDao.save(playersubscription);
		return "Playersubscription Approved!!!";
		}else {
			return "Playersubscription is pending!!!";
		}
		}else {
			return "Playersubscription not InProgress !!!";
		}
	}
}
