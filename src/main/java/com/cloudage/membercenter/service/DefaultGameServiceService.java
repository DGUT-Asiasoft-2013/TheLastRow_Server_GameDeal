package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.repository.IGameRepository;
import com.cloudage.membercenter.repository.IGameServiceRepository;

@Component
@Service
@Transactional
public class DefaultGameServiceService implements IGameServiceService {

	@Autowired
	IGameServiceRepository gameserviceRepo;
	
	@Override
	public List<GameService> findByGameName(String gamename) {
		return gameserviceRepo.findGameServiceByGameName(gamename);
	}

	@Override
	public GameService findByGameServiceName(String gameservicename,String gamename) {
		return gameserviceRepo.findGameServiceByGameServiceName(gameservicename,gamename);
	}

	@Override
	public List<GameService> getAllGameService() {
		Sort sort = new Sort(Direction.ASC,"game");
		return (List<GameService>) gameserviceRepo.findAll(sort);
	}

}
