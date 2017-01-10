package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.hibernate.type.TrueFalseType;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class Game extends BaseEntity{

	Company company;
	String gamename;
	

	@ManyToOne(optional = false)
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	@Column(unique = true , nullable = false)
	public String getGamename() {
		return gamename;
	}
	
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	
	
}
