/*package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.daos.AdminDao;
import com.cybage.models.Admin;
import com.cybage.models.Player;

@SpringBootTest
public class AdminServiceTest {
	 @MockBean
	 AdminDao admindao;
	 
	 
	 
	 @Test
	    void testfindPlayerByEmailAndPassword() {
	    	Admin admin=new Admin();
	    	
	    	admin.setEmail("suchidp@gmail.com");
	    	admin.setPassword("123456");
	    	admin.setAdmin_id(1);
	    	
	        Mockito.doReturn(admin).when(admindao).findAdminByEmailAndPassword("suchidp@gmail.com","123456");

	        assertEquals(1, admindao.findAdminByEmailAndPassword("suchidp@gmail.com","123456").getAdmin_id());
	    }
	 
	 
	 
	 
}
*/