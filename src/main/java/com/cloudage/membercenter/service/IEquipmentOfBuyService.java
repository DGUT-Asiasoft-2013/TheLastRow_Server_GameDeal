package com.cloudage.membercenter.service;

import java.util.List;

import com.cloudage.membercenter.entity.EquipmentOfBuy;
import com.cloudage.membercenter.entity.User;

public interface IEquipmentOfBuyService {

	EquipmentOfBuy save(EquipmentOfBuy equipment);
	
	
	List<EquipmentOfBuy> findByOwner(User user);
	
	List<EquipmentOfBuy> findByOwnerId(Integer id);
	
	List<EquipmentOfBuy> findByCompanyName(String companyname);
	
	List<EquipmentOfBuy> findByGameName(String gamename);
	
	List<EquipmentOfBuy> findByGameServiceName(String gameservicename , String gamename);
	
	List<EquipmentOfBuy> findByEquipName(String equipname);
	
	List<EquipmentOfBuy> getAllEquipmentOfBuy();
}
