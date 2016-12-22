package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class Recharge   extends BaseEntity  {
	User user;
	String money;
	String moneyrecord;

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

	
	

