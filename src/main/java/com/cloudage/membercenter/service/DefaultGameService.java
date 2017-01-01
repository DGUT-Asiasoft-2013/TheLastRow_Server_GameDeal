package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.repository.IGameRepository;

@Component
@Service
@Transactional
public class DefaultGameService implements IGameService {

	@Autowired
	IGameRepository gameRepo;
	
	@Override
	public List<Game> findByCompanyName(String companyname) {
		return gameRepo.findGameByCompanyName(companyname);
	}

	@Override
	public Game findByGameName(String gamename) {
		return gameRepo.findGameByGameName(gamename);
	}

	@Override
	public List<Game> getAllGame() {
		Sort sort = new Sort(Direction.ASC,"company");
		return (List<Game>) gameRepo.findAll(sort);
	}

}
