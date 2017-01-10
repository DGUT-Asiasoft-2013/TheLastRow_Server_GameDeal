package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.EquipmentOfBuy;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IEquipmentOfBuyRepository;

@Component
@Service
@Transactional
public class DefaultEquipmentOfBuyService implements IEquipmentOfBuyService {

	@Autowired
	IEquipmentOfBuyRepository equipofbuyRepo;
	
	@Override
	public EquipmentOfBuy save(EquipmentOfBuy equipment) {
		return equipofbuyRepo.save(equipment);
	}

	@Override
	public List<EquipmentOfBuy> findByOwner(User user) {
		return equipofbuyRepo.findEquipmentOfBuyByOwner(user);
	}

	@Override
	public List<EquipmentOfBuy> findByOwnerId(Integer id) {
		return equipofbuyRepo.findEquipmentOfBuyByOwnerId(id);
	}

	@Override
	public List<EquipmentOfBuy> findByCompanyName(String companyname) {
		return equipofbuyRepo.findEquipmentOfBuyByCompanyName(companyname);
	}

	@Override
	public List<EquipmentOfBuy> findByGameName(String gamename) {
		return equipofbuyRepo.findEquipmentOfBuyByGameName(gamename);
	}

	@Override
	public List<EquipmentOfBuy> findByGameServiceName(String gameservicename, String gamename) {
		return equipofbuyRepo.findEquipmentOfBuyByGameServiceName(gameservicename, gamename);
	}

	@Override
	public List<EquipmentOfBuy> findByEquipName(String equipname) {
		return equipofbuyRepo.findEquipmentOfBuyByEquipName(equipname);
	}

	@Override
	public List<EquipmentOfBuy> getAllEquipmentOfBuy() {
		Sort sort = new Sort(Direction.ASC,"createDate");
		return (List<EquipmentOfBuy>) equipofbuyRepo.findAll(sort);
	}

}
