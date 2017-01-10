package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.entity.User;


@Repository
public interface IEquipmentRepository extends PagingAndSortingRepository<Equipment, Integer>{
	
	@Query("from Equipment e where e.id = ?1")
	Equipment findEquipmentById(Integer id);
	
	@Query("from Equipment e where e.owner = ?1")
	List<Equipment> findEquipmentByOwner(User user);
	
	@Query("from Equipment e where e.owner.id = ?1")
	List<Equipment> findEquipmentByOwnerId(Integer id);
	
	@Query("from Equipment e where e.gameservice.game.company.companyname = ?1")
	List<Equipment> findEquipmentByCompanyName(String companyname);
	
	@Query("from Equipment e where e.gameservice.game.gamename = ?1")
	List<Equipment> findEquipmentByGameName(String gamename);
	
	@Query("from Equipment e where e.gameservice.gameservicename = ?1 and e.gameservice.game.gamename = ?2")
	List<Equipment> findEquipmentByGameServiceName(String gameservicename , String gamename);

	@Query("from Equipment e where e.equipname like %?1%")
	List<Equipment> findEquipmentByEquipName(String equipname);
	
	@Query("from Equipment e where e.isSell = ?1")
	List<Equipment> findEquipmentBySellOrBuy(Boolean isSell);
	
	@Query("from Equipment e where e.id=?1")
	Equipment findEquipmentById(int equipId);
}
