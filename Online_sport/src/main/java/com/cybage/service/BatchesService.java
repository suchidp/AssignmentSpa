package com.cybage.service;

import java.util.List;

import com.cybage.models.Batches;

public interface BatchesService {
	void addToBatches(Batches batches);

	List<Batches> getBatchesItems(int managerId);

	void updateBatchName(Batches batches);
}
