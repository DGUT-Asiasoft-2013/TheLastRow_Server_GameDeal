package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;

public class Transfer extends BaseEntity  {

User user;
String money;
String moneymecord;
@ManyToOne(optional=false)
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Column(nullable=false,unique=true)
public String getMoney() {
	return money;
}
@Column(nullable=false,unique=true)
public void setMoney(String money) {
	this.money = money;
}
public String getMoneymecord() {
	return moneymecord;
}
public void setMoneymecord(String moneymecord) {
	this.moneymecord = moneymecord;
}

}
