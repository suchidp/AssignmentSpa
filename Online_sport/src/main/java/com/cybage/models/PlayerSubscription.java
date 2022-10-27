package com.cybage.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

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
@Table(name = "playersubscription")
@Component

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "playerSubscriptionId")
public class PlayerSubscription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int playerSubscriptionId;

	private EnrollmentStatus enrollmentstatus;

	@JsonIgnore
	@OneToOne(mappedBy = "playersubscription")
	private Batches batches;

	@ManyToOne
	@JsonBackReference(value = "playersubscription")
	@JoinColumn(name = "player_id")
	private Player play;

	@ManyToOne
	@JsonBackReference(value = "playersubscriptions")
	@JoinColumn(name = "manager_id")
	private Manager subscription;

	public PlayerSubscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlayerSubscription(int playerSubscriptionId, EnrollmentStatus enrollmentstatus, Batches batches, Player play,
			Manager subscription) {
		super();
		this.playerSubscriptionId = playerSubscriptionId;
		this.enrollmentstatus = enrollmentstatus;
		this.batches = batches;
		this.play = play;
		this.subscription = subscription;
	}

	public int getPlayerSubscriptionId() {
		return playerSubscriptionId;
	}

	public void setPlayerSubscriptionId(int playerSubscriptionId) {
		this.playerSubscriptionId = playerSubscriptionId;
	}

	public EnrollmentStatus getEnrollmentstatus() {
		return enrollmentstatus;
	}

	public void setEnrollmentstatus(EnrollmentStatus enrollmentstatus) {
		this.enrollmentstatus = enrollmentstatus;
	}

	public Batches getBatches() {
		return batches;
	}

	public void setBatches(Batches batches) {
		this.batches = batches;
	}

	public Player getPlay() {
		return play;
	}

	public void setPlay(Player play) {
		this.play = play;
	}

	public Manager getSubscription() {
		return subscription;
	}

	public void setSubscription(Manager subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "PlayerSubscription [playerSubscriptionId=" + playerSubscriptionId + ", enrollmentstatus="
				+ enrollmentstatus + ", batches=" + batches + ", play=" + play + ", subscription=" + subscription + "]";
	}

}
