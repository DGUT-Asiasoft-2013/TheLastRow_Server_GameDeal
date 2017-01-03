package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.EquipmentOfBuy;
import com.cloudage.membercenter.entity.User;

@Repository
public interface IEquipmentOfBuyRepository extends PagingAndSortingRepository<EquipmentOfBuy, Integer> {

	@Query("from EquipmentOfBuy e where e.owner = ?1")
	List<EquipmentOfBuy> findEquipmentOfBuyByOwner(User user);
	
	@Query("from EquipmentOfBuy e where e.owner.id = ?1")
	List<EquipmentOfBuy> findEquipmentOfBuyByOwnerId(Integer id);
	
	@Query("from EquipmentOfBuy e where e.gameservice.game.company.companyname = ?1")
	List<EquipmentOfBuy> findEquipmentOfBuyByCompanyName(String companyname);
	
	@Query("from EquipmentOfBuy e where e.gameservice.game.gamename = ?1")
	List<EquipmentOfBuy> findEquipmentOfBuyByGameName(String gamename);
	
	@Query("from EquipmentOfBuy e where e.gameservice.gameservicename = ?1 and e.gameservice.game.gamename = ?2")
	List<EquipmentOfBuy> findEquipmentOfBuyByGameServiceName(String gameservicename , String gamename);

	@Query("from EquipmentOfBuy e where e.equipname like '%?1%'")
	List<EquipmentOfBuy> findEquipmentOfBuyByEquipName(String equipname);
}
