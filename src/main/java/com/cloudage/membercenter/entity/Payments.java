package com.cloudage.membercenter.entity;

import com.cloudage.membercenter.util.BaseEntity;

public class Payments extends BaseEntity{
     User user;
     String cash;
     String cashrecord;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getRecord() {
		return cashrecord;
	}
	public void setRecord(String record) {
		this.cashrecord = record;
	}
     	
}
