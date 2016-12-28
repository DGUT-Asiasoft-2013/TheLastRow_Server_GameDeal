package com.cloudage.membercenter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.stereotype.Component;

import com.cloudage.membercenter.util.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Inbox extends BaseEntity implements Serializable{
	
	/*私信内容
	 * 发送者id
	 * 接收者id
	 * 是否已读
	 * 时间
	 */
	
	
	String inboxContent;
	User senduser;
	User recuser;
	boolean isread;
	Date createDate;
	String sign;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getInboxContent() {
		return inboxContent;
	}
	public void setInboxContent(String content) {
		this.inboxContent = content;
	}

	
	@ManyToOne(optional=false)
	public User getSenduser() {
		return senduser;
	}

	public void setSenduser(User senduser) {
		this.senduser = senduser;
	}
	@ManyToOne(optional=false)
	@JsonIgnore
	public User getRecuser() {
		return recuser;
	}

	public void setRecuser(User recuser) {
		this.recuser = recuser;
	}
	
	
	
	public boolean isIsread() {
		return isread;
	}
	public void setIsread(boolean isread) {
		this.isread = isread;
	}
	
	@Column(updatable = false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@PrePersist
	void onPrePersist(){
		createDate = new Date();
	}
}