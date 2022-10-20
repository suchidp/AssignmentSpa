/*package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.cybage.daos.PlayersDao;

import com.cybage.models.Player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class PlayerServiceTest {

	 @MockBean
	    PlayersDao playerd;

	   

	    @Test
	    void testgetPlayer() {
	        List<Player> playerList=new ArrayList<>();
	        Player player=new Player();
	        Player player1=new Player();

	        playerList.add(player);
	        playerList.add(player1);

	        Mockito.doReturn( playerList).when(playerd).findAll();

	        assertEquals(2, playerd.findAll().size());
	    }


	    @Test
	    void testgetPlayerById() {
	    	Player player=new Player();
	    	player.setPlayer_id(11);
	        player.setEmail("sbparbat@gmail.com");
	        Optional<Player> player1=Optional.of(player);
	        Mockito.doReturn(player).when(playerd).getPlayerById(11);

	        assertEquals("sbparbat@gmail.com", playerd.getPlayerById(11).getEmail());
	    }
	   
   

    @Test
    void testfindPlayerByEmailAndPassword() {
    	Player player=new Player();
    	player.setEmail("suchidp@gmail.com");
    	player.setPassword("123456");
        player.setWeight(5);
        Mockito.doReturn(player).when(playerd).findPlayerByEmailAndPassword("suchidp@gmail.com","123456");

        assertEquals(5, playerd.findPlayerByEmailAndPassword("suchidp@gmail.com","123456").getWeight());
    }

    
    
 
  
    @Test
    void testsavePlayer() {
    	Player player=new Player();
       player.setWeight(21);
        Mockito.doReturn(player).when(playerd).save(player);

        assertEquals(21, playerd.save(player).getWeight());
    }

    @Test
    void testsavePlayer2() {
    	Player player=new Player();
        player.setAddress("cybageoffice");

        Mockito.doReturn(player).when(playerd).save(player);

        assertEquals("cybageoffice", playerd.save(player).getAddress());
    }

   

  

   

  
}*/
