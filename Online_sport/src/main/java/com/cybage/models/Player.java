package com.cybage.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Component
@Table(name="players")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "playerId")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int playerId;
	@JsonIgnore
	@NotNull
	private String password;
	
	@NotNull
	@Email(message= "Please enter the valid email address")
	private String email;
	
	private String address;
	
	private String age;
	 
	private int weight;
	
	
	@OneToMany(mappedBy ="play")
	 @JsonManagedReference(value="playersubscription")
	@JsonIgnore
	    private List<PlayerSubscription> playersubscription;
	/*
	 @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    @JoinColumn(name = "playersubscription_id")
	    private Playersubscription playersubscription;*/
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(int playerId, @NotNull String password,
			@NotNull @Email(message = "Please enter the valid email address") String email, String address, String age,
			int weight, List<PlayerSubscription> playersubscription) {
		super();
		this.playerId = playerId;
		this.password = password;
		this.email = email;
		this.address = address;
		this.age = age;
		this.weight = weight;
		this.playersubscription = playersubscription;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<PlayerSubscription> getPlayersubscription() {
		return playersubscription;
	}
	public void setPlayersubscription(List<PlayerSubscription> playersubscription) {
		this.playersubscription = playersubscription;
	}
	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", password=" + password + ", email=" + email + ", address=" + address
				+ ", age=" + age + ", weight=" + weight + ", playersubscription=" + playersubscription + "]";
	}
	
	
	
	
	
}
