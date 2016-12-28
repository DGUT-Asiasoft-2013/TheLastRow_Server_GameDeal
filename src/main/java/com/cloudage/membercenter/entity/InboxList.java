package com.cloudage.membercenter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import com.cloudage.membercenter.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Entity
public class InboxList extends BaseEntity implements Serializable{

	
	
	Inbox last_inbox;
	String sign;
	String sendname;
	String recname;
	Date createDate;
	
	
	public Inbox getLast_inbox() {
		return last_inbox;
	}
	public void setLast_inbox(Inbox last_inbox) {
		this.last_inbox = last_inbox;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSendname() {
		return sendname;
	}
	public void setSendname(String sendname) {
		this.sendname = sendname;
	}
	public String getRecname() {
		return recname;
	}
	public void setRecname(String recname) {
		this.recname = recname;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}