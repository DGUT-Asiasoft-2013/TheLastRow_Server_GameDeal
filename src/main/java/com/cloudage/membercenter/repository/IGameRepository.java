package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Game;

@Repository
public interface IGameRepository extends PagingAndSortingRepository<Game,Integer>{
	
	@Query("from Game g where g.company.companyname = ?1")
	List<Game> findGameByCompanyName(String companyname);
	
	@Query("from Game g where g.gamename = ?1")
	Game findGameByGameName(String gamename);
}
