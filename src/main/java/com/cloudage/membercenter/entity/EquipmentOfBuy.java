package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.DateRecord;

@Entity
public class EquipmentOfBuy extends DateRecord {

	User owner;
	GameService gameservice;
	
	String equipname;	
	String minvalue;	
	String gameid;
	
	Integer equipnumber;
	
	String[] equippicture;

	
	
	@Column(nullable = false)
	public String getGameid() {
		return gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = gameid;
	}

	@ManyToOne(optional = false)
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@ManyToOne(optional = false)
	public GameService getGameservice() {
		return gameservice;
	}

	public void setGameservice(GameService gameservice) {
		this.gameservice = gameservice;
	}

	@Column(nullable = false,updatable = false)
	public String getEquipname() {
		return equipname;
	}

	public void setEquipname(String equipname) {
		this.equipname = equipname;
	}

	@Column(updatable = false)
	public String getMinvalue() {
		return minvalue;
	}

	public void setMinvalue(String minvalue) {
		this.minvalue = minvalue;
	}

	@Column(updatable = false)
	public Integer getEquipnumber() {
		return equipnumber;
	}

	public void setEquipnumber(Integer equipnumber) {
		this.equipnumber = equipnumber;
	}

	
	public String[] getEquippicture() {
		return equippicture;
	}

	public void setEquippicture(String[] equippicture) {
		this.equippicture = equippicture;
	}

	
}
