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
import com.cybage.models.Batches;
import com.cybage.models.Player;

@SpringBootTest
public class BatchesServiceTest {
	@MockBean
	BatchesDao batchdao;
	
	
	
	
	
	 @Test
	    void testaddBatches() {
	    	Batches batch=new Batches();
	       batch.setBatch_name("Morning");
	        Mockito.doReturn(batch).when(batchdao).save(batch);

	        assertEquals("Morning", batchdao.save(batch).getBatch_name());
	    }
	 @Test
	    void testgetBatchesById() {
		 Batches batch=new Batches();
		 batch.setBatch_id(1);;
		 batch.setBatch_name("eveining");
	        Optional<Batches> batch1=Optional.of(batch);
	        Mockito.doReturn(batch).when(batchdao).getBatchesById(1);

	        assertEquals("eveining",batchdao.getBatchesById(1).getBatch_name());
	    }
	
	 
	 
	  @Test
	    void testdeleteBatchesDetails() {

	    }
	 @Test
	    void testgetBatches() {
	        List<Batches> batchesList=new ArrayList<>();
	        Batches batches=new Batches();
	       

	        batchesList.add(batches);
	        

	        Mockito.doReturn( batchesList).when(batchdao).findAll();

	        assertEquals(1, batchdao.findAll().size());
	    } 
}
*/