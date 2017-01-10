package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;
import com.cloudage.membercenter.util.DateRecord;

@Entity
public class Recharge  extends DateRecord  {
	User user;
	String money;
	String moneyrecord;
	Equipment equipment;
	
	
	@ManyToOne(optional=false)
//	@Column(nullable=true)
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@ManyToOne(optional=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	

	public String getMoneyrecord() {
		return moneyrecord;
	}

	public void setMoneyrecord(String moneyrecord) {
		this.moneyrecord = moneyrecord;
	}

	
	


	
	}

	
	

