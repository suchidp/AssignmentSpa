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
import com.cybage.service.ManagerService;
import com.cybage.service.SportService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")


public class AdminController {
	//static Logger logger = LogManager.getLogger(Admincontroller.class);
	@Autowired
	AdminServiceImpl adminservice;
	@Autowired
	SportService sportservice;
	@Autowired
	ManagerService managerservice;

	/* 
	 * Registation of Admin 
	 * 
	 * 
	 * @PostMapping("/registeradmin") public
	 * ResponseEntity<?>saveadminDetails(@RequestBody @Valid Admin admin) {
	 * System.out.println("In save admin");
	 * 
	 * return new
	 * ResponseEntity<>(adminservice.saveadminDetails(admin),HttpStatus.CREATED); }
	 */

	
	//Login of Admin
	@PostMapping("/login")
	public Admin loginAdmin(@RequestBody @Valid LoginRequest payload) {
		System.out.println("auth cust " + payload);
		return adminservice.findAdminByEmailAndPassword(payload.getEmail(), payload.getPassword());
	}

	
	// List Of Manager
	@GetMapping("/manager")
	public List<Manager> getManager() {
		return managerservice.getall();
	}

	
	// Manager By Id
	@GetMapping("/manager/{managerId}")
	public ResponseEntity<?> getManagertById(@PathVariable int managerId) {
		System.out.println("manager details " + managerId);

		return ResponseEntity.ok(managerservice.getManagertById(managerId));

	}

	/*  Admin registration by DTO
	 * 
	 * @PostMapping("") public ResponseEntity<?> save(AdminDTO admindto) { Admin
	 * admin = AdminDTO.toEntity(admindto); admin = adminservice.saveAdmin(admin);
	 * return Response.success(admin); }
	 * 
	 */

	
	// Create credentials of  Manager by admin
	@PostMapping("/manager")
	public ResponseEntity<?> registerManager(@RequestBody @Valid Manager manager) {
		System.out.println("In save manager");

		return new ResponseEntity<>(managerservice.saveManager(manager), HttpStatus.CREATED);
	}

	
	// List of sport 
	@GetMapping("/sport")
	public List<Sport> getSportList() {
		return sportservice.getSportList();
	}

	
	// Add Sport by Admin 
	@PostMapping("/sport")
	public ResponseEntity<?> saveSportDetails(@RequestBody @Valid Sport sport) {
		System.out.println("sport added");

		return new ResponseEntity<>(sportservice.saveSport(sport), HttpStatus.CREATED);
	}
    
	
	
	
	//Get sport by SportId
	@GetMapping("/sport/{sportId}")
	public ResponseEntity<?> getSportDetailsById(@PathVariable int sportId) {
		System.out.println("sport details " + sportId);

		return ResponseEntity.ok(sportservice.getSportById(sportId));

	}

	
	
	//Delete Sport by ID
	@DeleteMapping("/sport/{sportId}")
	public ResponseEntity<String> deleteSportDetails(@PathVariable int sportId) {
		System.out.println("delete sportdetails " + sportId);

		return ResponseEntity.ok(sportservice.deleteSportDetails(sportId));
	}
	
	
	
	
	
	//Edit Sport

	@PutMapping("/sport/{id}")
	public ResponseEntity<?> updateSportDetails(@RequestBody Sport detachedsport, @PathVariable("id") int sportId)
			throws CustomException {

		if (updateSportDetails(detachedsport, sportId) != null) {
			return ResponseEntity.ok(sportservice.updateSportDetails(detachedsport, sportId));
		}
		throw new CustomException("Sport not found");
	}

	
	//	Logout Admin
	@PostMapping("/logout")
	public ResponseEntity<?> adminLogout(@RequestBody Admin admin) throws CustomException {
		// userService.findByUserEmail(email);
		// logger.info(admin.getAdmin_id()+" Logged out successfully");
		return new ResponseEntity<>("Admin Logged Out Successfully", HttpStatus.OK);
	}
}
