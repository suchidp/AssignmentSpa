package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.PlayersDao;
import com.cybage.models.Batches;
import com.cybage.models.Player;

@Service
public class PlayerService {
	@Autowired
	PlayersDao playerDao;
	
	public Player savePlayer (Player player) {
		return playerDao.save(player);
	}
	public Player findPlayerByEmailAndPassword(String email, String password) {
		return playerDao.findPlayerByEmailAndPassword(email, password);
	}
	public List<Player> getPlayer() {
		// TODO Auto-generated method stub
		return playerDao.findAll();
	}
public Player getPlayerById(int playerId) {
		
		return playerDao.findById(playerId).get();
	}
}
