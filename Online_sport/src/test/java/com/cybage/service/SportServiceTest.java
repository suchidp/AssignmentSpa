/*package com.cybage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.daos.PlayersDao;
import com.cybage.daos.SportDao;
import com.cybage.models.Batches;
import com.cybage.models.Sport;

@SpringBootTest
public class SportServiceTest {
	@MockBean
    SportDao sportdao;
	
	@Test
    void testsaveSport() {
    	Sport sport=new Sport();
       sport.setSportname("cricket");
        Mockito.doReturn(sport).when(sportdao).save(sport);

        assertEquals("cricket", sportdao.save(sport).getSportname());
    }
 @Test
    void testgetSportById() {
	 Sport sport=new Sport();
	 sport.setSport_id(1);
     sport.setSportname("cricket");
        Optional<Sport> sport1=Optional.of(sport);
        Mockito.doReturn(sport).when(sportdao).getSportById(1);

        assertEquals("cricket",sportdao.getSportById(1).getSportname());
    }

 
 
  @Test
    void testdeleteSportDetails() {

    }
 @Test
    void testgetall() {
        List<Sport> sportList=new ArrayList<>();
        Sport sport=new Sport();
       

        sportList.add(sport);
        

        Mockito.doReturn( sportList).when(sportdao).findAll();

        assertEquals(1, sportdao.findAll().size());
    } 
}*/
