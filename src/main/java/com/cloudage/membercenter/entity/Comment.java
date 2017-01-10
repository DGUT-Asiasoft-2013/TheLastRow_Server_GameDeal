package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.BaseEntity;
import com.cloudage.membercenter.util.DateRecord;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Comment extends DateRecord {
	String text;
	User author;
	Equipment equipment;
	float score;
	

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getText() {
		return text;
	}

	@ManyToOne(optional = false)
	public User getAuthor() {
		return author;
	}

	
	
	public void setText(String text) {
		this.text = text;
	}
	@ManyToOne(optional = false)
	@JsonIgnore
	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	

}
