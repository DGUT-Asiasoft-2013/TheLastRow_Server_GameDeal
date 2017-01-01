package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;

@Repository
public interface IGameServiceRepository extends PagingAndSortingRepository<GameService, Integer>{

	@Query("from GameService gs where gs.game.gamename = ?1")
	List<GameService> findGameServiceByGameName(String gamename);
	
	@Query("from GameService gs where gs.gameservicename = ?1 and gs.game.gamename = ?2")
	GameService findGameServiceByGameServiceName(String gameservicename,String gamename);
}
