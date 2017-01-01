package com.cloudage.membercenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cloudage.membercenter.util.BaseEntity;

@Entity
public class GameService extends BaseEntity{

	Game game;
	String gameservicename;
	

	@ManyToOne(optional = false)
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	@Column(nullable = false)
	public String getGameservicename() {
		return gameservicename;
	}

	public void setGameservicename(String gameservicename) {
		this.gameservicename = gameservicename;
	}
	
}
