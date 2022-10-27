package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.daos.BatchesDao;
import com.cybage.models.Batches;

@Service
public class BatchesServiceImpl implements BatchesService {

	@Autowired
	BatchesDao batchesdao;

	
	
	//Add batches and create subscription
	public void addToBatches(Batches batches) {
		int sportId = batches.getSport_batch().getSportId();
		int managerId = batches.getManager_batch().getManagerId();
		batches.setBatchName(batches.getBatchName());
		batches.setManager_batch(batches.getManager_batch());
		batches.setSport_batch(batches.getSport_batch());
		batches.setOffer(batches.getOffer());

		batchesdao.save(batches);
	}

	
	
	//Find batch by batchId
	public Batches getBatchesById(int batchId) {

		return batchesdao.findById(batchId).get();
	}
	
	
	
  //Update batch details
	public Batches updateBatchesDetails(Batches batches, int batchId) {

		Batches batches1 = batchesdao.getBatchesById(batchId);

		batches1.setBatchName(batches.getBatchName());
		Batches batchDetails = batchesdao.save(batches1);
		return batchDetails;
	}

	
	//Delete batch by batchId
	public void deleteBatches(int batchId) {

		batchesdao.deleteById(batchId);

	}

	
	//List of batches
	public List<Batches> getBatches() {
		// TODO Auto-generated method stub
		return batchesdao.findAll();
	}

	
	//List of batches by managerId
	public List<Batches> getBatchesByManager(int manager_id) {
		// TODO Auto-generated method stub
		return batchesdao.findBymanagerId(manager_id);
	}

	@Override
	public List<Batches> getBatchesItems(int managerId) {
		// TODO Auto-generated method stub
		return batchesdao.findBymanagerId(managerId);
	}

	@Override
	public void updateBatchName(Batches batches) {
		batchesdao.save(batches);
	}

}
