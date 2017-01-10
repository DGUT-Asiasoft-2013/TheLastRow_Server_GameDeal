package com.cloudage.membercenter.service;

import java.util.List;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Game;

public interface IGameService {
	
	List<Game> findByCompanyName(String companyname);
	
	List<Game> getAllGame();
	
	Game findByGameName(String gamename);
}
