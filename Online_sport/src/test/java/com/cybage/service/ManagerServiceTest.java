/*package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.daos.BatchesDao;
import com.cybage.daos.ManagerDao;
import com.cybage.models.Manager;
import com.cybage.models.Player;

@SpringBootTest
public class ManagerServiceTest {
	@MockBean
	ManagerDao managerdao;
	
	 @Test
	    void testgetall() {
	        List<Manager> managerList=new ArrayList<>();
	        Manager manager=new Manager();
	        

	        managerList.add(manager);
	        

	        Mockito.doReturn( managerList).when(managerdao).findAll();

	        assertEquals(1, managerdao.findAll().size());
	    }


	    @Test
	    void testgetManagertById() {
	    	 Manager manager=new Manager();
	    	manager.setManager_id(1);
	       manager.setEmail("suchidp@gmail.com");
	        Optional <Manager> managers=Optional.of(manager);
	        Mockito.doReturn(manager).when(managerdao).getManagerById(1);

	        assertEquals("suchidp@gmail.com", managerdao.getManagerById(1).getEmail());
	    }
	   


 @Test
 void testfindManagerByEmailAndPassword() {
	 Manager manager=new Manager();
 	
    manager.setEmail("suchidp@gmail.com");
    manager.setPassword("suchid");
     manager.setManager_id(1);
     Mockito.doReturn(manager).when(managerdao).findManagerByEmailAndPassword("suchidp@gmail.com","suchid");

     assertEquals(1, managerdao.findManagerByEmailAndPassword("suchidp@gmail.com","suchid").getManager_id());
 }

 
 


 @Test
 void testsaveManager() {
	 Manager manager=new Manager();
    manager.setEmail("suchidp@gmail.com");
     Mockito.doReturn(manager).when(managerdao).save(manager);

     assertEquals("suchidp@gmail.com", managerdao.save(manager).getEmail());
 }



}*/
