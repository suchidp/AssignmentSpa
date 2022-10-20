/*package com.cybage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.cybage.daos.PlayersDao;
import com.cybage.daos.PlayerSubscriptionDao;
import com.cybage.models.Manager;
import com.cybage.models.PlayerSubscription;

@SpringBootTest
public class PlayerSubscriptionServiceTest {
	 @MockBean
	    PlayerSubscriptionDao playersubscription;
	 
	 @Test
	    void getSubscriptionById() {
		 PlayerSubscription playersub=new PlayerSubscription();
	        Optional<PlayerSubscription> playersub1=Optional.of(playersub);
	        playersub.setPlayersubscription_id(21);

	        Mockito.when(playersubscription.findById(21)).thenReturn(playersub1);

	        assertEquals(21,playersubscription.findById(21).get().getPlayersubscription_id());
	    }
	 
	
	    @Test
	    void testselectSubscription() {
	    	PlayerSubscription playersub=new PlayerSubscription();
	    	playersub.setPlayersubscription_id(11);

	        Mockito.doReturn( playersub).when(playersubscription).save(playersub);

	        assertEquals(11,playersubscription.save(playersub).getPlayersubscription_id());
	    }
	 /*  
	    
	    @Test
	    void testgetPlayersubscription() {
	    	List<Playersubscription> playersubscriptionList=new ArrayList<>();
	    	Playersubscription playersubscription=new Playersubscription();
	    	Playersubscription playersubscription1=new Playersubscription();
	    	Playersubscription playersubscription2=new Playersubscription();

	    	playersubscriptionList.add(playersubscription);
	    	playersubscriptionList.add(playersubscription1);
	    	playersubscriptionList.add(playersubscription2);

	        Mockito.doReturn(playersubscriptionList).when(playersubscription).findAll();

	        assertEquals(3, playersubscription.findAll().size());
	        
	    }
	    
	    
	    @Test
	    void findPlayersubscriptionBymanagerId() {
	    	List<Playersubscription> playersubscriptionList=new ArrayList<>();
	        Manager manager=new Manager();
	        Playersubscription playersubscription=new Playersubscription();
	        playersubscription.setSubscription(manager);
	        Playersubscription playersubscription1=new Playersubscription();
	        playersubscription1.setSubscription(manager);

	        playersubscriptionList.add(playersubscription);
	        playersubscriptionList.add(playersubscription1);

	        Mockito.doReturn(playersubscriptionList).when(playersubscription).getSubscription();

	        assertEquals(2, playersubscription.getSubscription().size());
	    }
}*/
