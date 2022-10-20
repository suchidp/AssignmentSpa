package com.cybage.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cybage.dto.LoginRequest;
import com.cybage.exception.CustomException;
import com.cybage.models.Batches;
import com.cybage.models.Player;
import com.cybage.models.PlayerSubscription;
import com.cybage.service.AdminService;
import com.cybage.service.PlayerService;
import com.cybage.service.PlayerSubscriptionService;
import com.cybage.service.SportService;


@RestController
@EnableAutoConfiguration
@RequestMapping("/player")
@CrossOrigin(origins = "*")
@Transactional
public class PlayerController {
	
	//static Logger logger=LogManager.getLogger(Playercontroller.class);
	@Autowired
	PlayerService playerservice;
	
	@Autowired
	PlayerSubscriptionService playersubscriptionservice;
	
	
	//Register login pf player
	
	@PostMapping("/register")
	public ResponseEntity<?> savePlayer(@RequestBody Player player){
		return new ResponseEntity<>(playerservice.savePlayer(player), HttpStatus.ACCEPTED);
	}

	@PostMapping("/login") //taking email and password through payload
	public Player loginPlayer(@RequestBody @Valid LoginRequest payload){
		System.out.println("auth cust "+payload);
		//logger.info("Player "+payload.getEmail()+" logged in");
		return playerservice.findPlayerByEmailAndPassword(payload.getEmail(),payload.getPassword());
	}
	
//Player operation
	@GetMapping("")
	public List<Player> getPlayer()
	{
		return playerservice.getPlayer();
	}
	
	@GetMapping("/{playerId}")
	public ResponseEntity<?> getPlayerById(@PathVariable int playerId)throws CustomException{
		System.out.println("player details "+ playerId);
		Player player = playerservice.getPlayerById(playerId);
		if(player==null){
			throw new CustomException("player not found");
		}
		return new ResponseEntity<>(player, HttpStatus.OK);
	}
	/*@GetMapping("/findplayer/{player_id}")
	public ResponseEntity<?> getPlayerById(@PathVariable int player_id){
		System.out.println("player details "+ player_id);
		

		return ResponseEntity.ok(playerservice.getPlayerById(player_id));
		
	}*/
	
@GetMapping("/{playerId}/playerSubcription")
public List<PlayerSubscription> getPlayersubscription()
{
	return playersubscriptionservice.getPlayersubscription();
}
		
}
