
package com.cybage.daos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cybage.models.Admin;
import com.cybage.models.Batches;

public interface BatchesDao extends JpaRepository<Batches, Integer> {
	
	@Query("select a from Batches a where a.batchId=:batchId")
	public Batches getBatchesById(int batchId);

	@Query(value = "select * from Batches c join manager r on c.manager_id=:managerId and r.manager_id=:managerId", nativeQuery = true)
	public List<Batches> findBymanagerId(int managerId);

	public Batches save(Batches batches);

	@Query("select u from Batches u")
	List<Batches> getBatches();

	// void deleteBatches (int batchId);
	// List<Batches> getByManagerId(int managerId);

	// Batches findByManagerIdAndSportId(int managerId, int sportId);

	// void deleteByUserId(int userId);

	// void deleteByUser(User user);
}
