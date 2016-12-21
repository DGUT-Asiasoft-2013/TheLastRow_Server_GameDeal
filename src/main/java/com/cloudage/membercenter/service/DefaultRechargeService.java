package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.cloudage.membercenter.entity.Recharge;
import com.cloudage.membercenter.repository.IRechargeRepository;

public class DefaultRechargeService implements IRechargeService {
	@Autowired
	IRechargeRepository rechargeRepo;

	public Page<Recharge> findRechargeOfUser(int userId, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page, 8, sort);
		return rechargeRepo.findAllOfUserId(userId, pageReqeust);
	}

	public Recharge save(Recharge recharge) {
		return rechargeRepo.save(recharge);
	}

	public int getIRechargeCountOfUser(int userId) {
		return rechargeRepo.rechargeCountOfUser(userId);
	}

	
}
