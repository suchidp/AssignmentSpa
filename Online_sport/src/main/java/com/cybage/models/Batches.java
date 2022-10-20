package com.cybage.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="batches")
@Component

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "batchId")

public class Batches {
	
	@Id
	 ///@Column(name = "batch_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
     private int batchId;
	@Column(length = 20, nullable = false)
  private String batchName;
	@Column(length = 20, nullable = false)
	  private String offer;
	
	 @ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="manager_id")
	  @JsonBackReference(value="manager_batch")
		private Manager manager_batch;
	/*
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    @JoinColumn(name = "sport_id")
	    private Sport sport;
*/
	 @ManyToOne
		@JoinColumn(name="sport_id")
	  @JsonBackReference(value="sport_batch")
		private Sport sport_batch;
		 
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "playersubscription_id")
	    private PlayerSubscription playersubscription;
	 
		public Batches() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Batches(int batchId, String batchName, String offer, Manager manager_batch, Sport sport_batch,
				PlayerSubscription playersubscription) {
			super();
			this.batchId = batchId;
			this.batchName = batchName;
			this.offer = offer;
			this.manager_batch = manager_batch;
			this.sport_batch = sport_batch;
			this.playersubscription = playersubscription;
		}

		public int getBatchId() {
			return batchId;
		}

		public void setBatchId(int batchId) {
			this.batchId = batchId;
		}

		public String getBatchName() {
			return batchName;
		}

		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}

		public String getOffer() {
			return offer;
		}

		public void setOffer(String offer) {
			this.offer = offer;
		}

		public Manager getManager_batch() {
			return manager_batch;
		}

		public void setManager_batch(Manager manager_batch) {
			this.manager_batch = manager_batch;
		}

		public Sport getSport_batch() {
			return sport_batch;
		}

		public void setSport_batch(Sport sport_batch) {
			this.sport_batch = sport_batch;
		}

		public PlayerSubscription getPlayersubscription() {
			return playersubscription;
		}

		public void setPlayersubscription(PlayerSubscription playersubscription) {
			this.playersubscription = playersubscription;
		}

		@Override
		public String toString() {
			return "Batches [batchId=" + batchId + ", batchName=" + batchName + ", offer=" + offer + ", manager_batch="
					+ manager_batch + ", sport_batch=" + sport_batch + ", playersubscription=" + playersubscription
					+ "]";
		}


		

		

		
	
	
	/*
	
	  @ManyToMany(mappedBy = "batches",fetch = FetchType.LAZY
		      
		     )
		  @JsonIgnore
		  private Set<Sport> sport = new HashSet<>();
	
	 @OneToMany(mappedBy ="batch")
	 @JsonManagedReference(value="manager")
	 private List<Manager> manager;
	 
	 -*/

	
	
	 
}
