package com.cloudage.membercenter.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.cloudage.membercenter.util.DateRecord;

@Entity
public class Good extends DateRecord{

	User author;
	String game_equip;
	//String text;
	int price;
	String avatar_img1;
	
	String game_name;
	String game_company;
	String game_account;
	String game_area;
	
	

	@ManyToOne(optional = false)
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getGame_equip() {
		return game_equip;
	}

	public void setGame_equip(String game_equip) {
		this.game_equip = game_equip;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAvatar_img1() {
		return avatar_img1;
	}

	public void setAvatar_img1(String avatar_img1) {
		this.avatar_img1 = avatar_img1;
	}

	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public String getGame_company() {
		return game_company;
	}

	public void setGame_company(String game_company) {
		this.game_company = game_company;
	}

	public String getGame_account() {
		return game_account;
	}

	public void setGame_account(String game_account) {
		this.game_account = game_account;
	}

	public String getGame_area() {
		return game_area;
	}

	public void setGame_area(String game_area) {
		this.game_area = game_area;
	}
	
	
}
