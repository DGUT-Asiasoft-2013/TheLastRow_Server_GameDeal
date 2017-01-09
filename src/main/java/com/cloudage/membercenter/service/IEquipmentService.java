package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.entity.Equipment;
import com.cloudage.membercenter.entity.Game;
import com.cloudage.membercenter.entity.GameService;
import com.cloudage.membercenter.entity.User;


public interface IEquipmentService {

	Equipment save(Equipment equipment);
	
	Equipment findById(Integer id);
	
	List<Equipment> findByOwner(User user);
	
	List<Equipment> findByOwnerId(Integer id);
	
	List<Equipment> findByCompanyName(String companyname);
	
	List<Equipment> findByGameName(String gamename);
	
	List<Equipment> findByGameServiceName(String gameservicename , String gamename);
	
	List<Equipment> findByEquipName(String equipname);
	
	List<Equipment> getAllEquipment();
	
	Page<Equipment> getByCreateDatePage(int page);
	
	Page<Equipment> getByLookCheckPage(int page);
	
	List<Equipment> findBySellOrBuy(Boolean isSell);
}
