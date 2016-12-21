package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;


import com.cloudage.membercenter.entity.Recharge;

public interface IRechargeService {
	Page<Recharge> findRechargeOfUser(int UserId, int page);

	Recharge save(Recharge recharge);

	int getRechargeCountOfUser(int UserId);
}
