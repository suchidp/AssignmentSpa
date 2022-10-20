package com.cybage.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;
import com.cybage.models.Batches;
import com.cybage.models.Player;



public interface PlayersDao extends JpaRepository<Player, Integer>{
	@Transactional
	@Modifying
	@Query("select a from Player a where a.playerId=:playerId")
	public Player getPlayerById(int playerId);
	//public Player savePlayer (Player player);
	
	@Query("select a from Player a where a.email =:email and a.password =:password")
	public Player findPlayerByEmailAndPassword(String email, String password);
	
	@Query("select u from Player u")
	List<Player> getPlayer();
	//public void deletePlayer(int playerId);

	
	
	//public User findByPlayer(int playerId);
	
}
