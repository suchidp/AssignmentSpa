package com.cybage.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.dto.LoginRequest;


import com.cybage.exception.CustomException;


import com.cybage.models.Admin;
import com.cybage.models.Batches;
import com.cybage.models.Manager;

import com.cybage.models.Sport;
import com.cybage.service.AdminServiceImpl;
import com.cybage.service.BatchesServiceImpl;
import com.cybage.service.ManagerService;
import com.cybage.service.PlayerSubscriptionService;
import com.cybage.service.SportService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/manager")
@CrossOrigin(origins = "*")
@Transactional
public class ManagerController {
	static Logger logger=LogManager.getLogger(Managercontrollers.class);
	@Autowired
	BatchesServiceImpl batchesservice;
	@Autowired
	ManagerService managerservice;
	
	@Autowired
	SportService  sportservice;
	
	
	@Autowired
	PlayerSubscriptionService  playersubscriptionservice;
	
	
	////Login operation/////
	
@PostMapping("/login") //taking email and password through payload
	
	public Manager loginManager(@RequestBody @Valid LoginRequest payload){
		System.out.println("auth cust "+payload);
		return managerservice.findManagerByEmailAndPassword(payload.getEmail(), payload.getPassword());
	}

@PostMapping("/logout")
public ResponseEntity<?> managerLogout(@RequestBody Manager manager) throws CustomException{
	
	logger.info(manager.getEmail())+" Logged out successfully");
	return new ResponseEntity<>("Manager Logged Out Successfully",HttpStatus.OK);
}

   ///Batches operation////
	
	
	
	@PostMapping("/batch")
	public ResponseEntity<String> addToBatches(@RequestBody Batches batches) {
		
		batchesservice.addToBatches(batches);
		logger.info("batch Added");
		return new ResponseEntity<String>("Carbatch Added successfully", HttpStatus.CREATED);
	}
		@GetMapping("/batch")
		public List<Batches> getBatches()
		{
			return batchesservice.getBatches();
		}
		
		
		@GetMapping("/batch/{batchId}")
		public ResponseEntity<?> getBatchesById(@PathVariable int batchId){
			System.out.println("sport details "+ batchId);
			

			return ResponseEntity.ok(batchesservice.getBatchesById(batchId));
			
		}
		
		@DeleteMapping("/batch/{batchId}")
		public ResponseEntity<?> deleteBatches(@PathVariable int batchId){
			batchesservice.deleteBatches(batchId);
			System.out.println("delete batchdetails "+batchId);
		

			return new ResponseEntity<>("batch Deleted successfully", HttpStatus.OK);
		}
		
		@PutMapping("/batch/update/{id}") 
		public ResponseEntity<?> updateBatchesDetails(@RequestBody Batches detachedbatches,@PathVariable("id") int batchId) throws CustomException{
		if(updateBatchesDetails(detachedbatches, batchId)!=null) {
			return ResponseEntity.ok(batchesservice.updateBatchesDetails(detachedbatches, batchId	));

			}
			throw new CustomException("Batch not found");
		}
		@GetMapping("/{managerId}/batch")
		public ResponseEntity<?> getBatchesByManager(@PathVariable int managerId){
			
			

			return ResponseEntity.ok(batchesservice.getBatchesByManager(managerId));
			
		}
		
		
		////sport operation//
		
		@GetMapping("/sport")
		public List<Sport> getSportList()
		{
			return sportservice.getSportList();
		}
		@GetMapping("/sport/{sportId}")
		public ResponseEntity<?> getSportById(@PathVariable int sportId){
			System.out.println("sport details "+ sportId);
			

			return ResponseEntity.ok(sportservice.getSportById(sportId));
			
		}
		
		
		@GetMapping("/{managerId}/sport")
		public ResponseEntity<?> getSportByManager(@PathVariable int managerId){
			
			

			return ResponseEntity.ok(sportservice.getSportByManager(managerId));
			
		}
		
		
		
		///subscription request//
		
		@GetMapping("/{managerId}/pendingSubscription")
		public ResponseEntity<?> findPendingPlayersubscriptionByManagerId(@PathVariable int managerId){
			System.out.println("in get requests  "+managerId);
			return ResponseEntity.ok(playersubscriptionservice.findPendingPlayersubscriptionByManagerId(managerId));
			
		}
	@GetMapping("/{managerId}/newSubscription")
		public ResponseEntity<?> findNewPlayersubscriptionByManagerId(@PathVariable int managerId){
			//System.out.println("in get requests  "+ownerId);
			return ResponseEntity.ok(playersubscriptionservice.findNewPlayersubscriptionByManagerId(managerId));
		}
	
	@GetMapping("/{managerId}/completesSubscription")
	public ResponseEntity<?> findCompletedPlayersubscriptionByManagerId (@PathVariable int managerId){
	
		return ResponseEntity.ok(playersubscriptionservice.findCompletedPlayersubscriptionByManagerId(managerId));
	}
	@GetMapping("{managerId}/RenewSubscription")
	public ResponseEntity<?> findRenewPlayersubscriptionByManagerId(@PathVariable int managerId){
	
		return ResponseEntity.ok(playersubscriptionservice.findRenewPlayersubscriptionByManagerId(managerId));
	}
	
	
	
	
	
	
	
	//-----------------------Status change of by manager 
		@PostMapping("/acceptSubscription/{playerSubscriptionId}")
		public ResponseEntity<?> acceptPlayersubscription(@PathVariable int playerSubscriptionId){
			System.out.println("in accept request "+playerSubscriptionId);
			return new ResponseEntity<>(playersubscriptionservice.acceptPlayersubscription(playerSubscriptionId),HttpStatus.CREATED);
		}
		
		@PostMapping("/rejectSubscription/{playerSubscriptionId}")
		public ResponseEntity<?> rejectPlayersubscription(@PathVariable int playerSubscriptionId){
			System.out.println("in reject request "+playerSubscriptionId);
			return new ResponseEntity<>(playersubscriptionservice.rejectPlayersubscription(playerSubscriptionId),HttpStatus.CREATED);
		}
		
		@PostMapping("/completeSubscription/{playerSubscriptionId}")
		public ResponseEntity<?> completeComplaint(@PathVariable int playerSubscriptionId){
			System.out.println("in complete request "+playerSubscriptionId);
			return new ResponseEntity<>(playersubscriptionservice.completePlayersubscription(playerSubscriptionId),HttpStatus.CREATED);
		}
		

}


