package com.cybage.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cybage.models.Batches;
import com.cybage.models.Player;
import com.cybage.models.PlayerSubscription;
import com.cybage.models.Sport;

public interface PlayerSubscriptionDao extends JpaRepository<PlayerSubscription, Integer> {
	
	@Query("select a from PlayerSubscription a where a.playerSubscriptionId=:playerSubscriptionId")
	public Player getPlayerSubscriptionById(int playerSubscriptionId);

	@Query(value = "select * from PlayerSubscription c join player r on c.player_id=:playerId and r.player_id=:playerId", nativeQuery = true)
	public List<PlayerSubscription> findByPlayer(int playerId);

	@Query(value = "select * from PlayerSubscription  b join manager d on b.manager_id=:managerId and d.manager_id=:managerId", nativeQuery = true)
	public List<PlayerSubscription> findPlayerSubscriptionBymanagerId(int managerId);

	@Query("select u from PlayerSubscription u")
	public List<PlayerSubscription> getPlayerSubscription();
	// public void deletePlayerSubscription(int playerSubscriptionId);

	// public User findByPlayer(int playerId);

	@Query(value = "select * from PlayerSubscription where manager_id =:managerId and EnrollmentStatus=0", nativeQuery = true)
	public List<PlayerSubscription> findNewPlayerSubscriptionByManagerId(int managerId);
//	public List<Complaint> findByUser(User user);

	@Query(value = "select * from PlayerSubscription where manager_id =:managerId and EnrollmentStatus=1 or EnrollmentStatus=2", nativeQuery = true)
	public List<PlayerSubscription> findPendingPlayerSubscriptionByManagerId(int managerId);

	@Modifying
	@Query(value = "select * from PlayerSubscription where manager_id =:managerId and EnrollmentStatus=3 or EnrollmentStatus=4", nativeQuery = true)
	public List<PlayerSubscription> findCompletedPlayerSubscriptionByManagerId(@Param("managerId") int managerId);

	@Query(value = "select * from PlayerSubscription where manager_id =:managerId and EnrollmentStatus=5 ", nativeQuery = true)
	public List<PlayerSubscription> findRenewPlayerSubscriptionByManagerId(@Param("managerId") int managerId);
}
