package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.DateRecord;


@Entity
public class Equipment extends DateRecord{

	User owner;
	GameService gameservice;
	
	String equipname;
	String equipvalue;
	String gameid;
	
	Integer equipnumber;
	
	String[] equippicture;
	Boolean isSell;
	
	@Column(nullable = false)
	public Boolean getIsSell() {
		return isSell;
	}

	public void setIsSell(Boolean isSell) {
		this.isSell = isSell;
	}

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

//	@Column(nullable = false , updatable = false)
	public String getEquipvalue() {
		return equipvalue;
	}

	public void setEquipvalue(String equipvalue) {
		this.equipvalue = equipvalue;
	}

	@Column(nullable = false , columnDefinition = "int default 1" , updatable = true)
	public int getEquipnumber() {
		return equipnumber;
	}

	public void setEquipnumber(Integer equipnumber) {
		this.equipnumber = equipnumber;
	}

	@Column(nullable = true)
	public String[] getEquippicture() {
		return equippicture;
	}

	public void setEquippicture(String[] equippicture) {
		this.equippicture = equippicture;
	}
	
}
