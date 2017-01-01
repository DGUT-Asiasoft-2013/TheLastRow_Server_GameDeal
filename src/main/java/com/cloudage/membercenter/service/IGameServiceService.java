package com.cloudage.membercenter.service;

import java.util.List;

import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;

public interface IGameServiceService {

	List<GameService> findByGameName(String gamename);
	
	List<GameService> getAllGameService();
	
	GameService findByGameServiceName(String gameservicename,String gamename);
}
