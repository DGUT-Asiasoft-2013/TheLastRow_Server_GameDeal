package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class Payments extends BaseEntity {
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

	public void setText(String text) {
		// TODO Auto-generated method stub
		
	}

	public void setAuthor(User me) {
		// TODO Auto-generated method stub
		
	}

	
	

}
