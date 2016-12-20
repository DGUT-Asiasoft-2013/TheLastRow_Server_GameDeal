package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IPaymentsRepository;

public class DefaultPaymentsService implements IPaymentsService{
	@Autowired
	IPaymentsRepository paymentsRepo;
	
	public Page<Payments> findPaymentsOfUser(int userId, int page){
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page,8, sort);
		return paymentsRepo.findAllOfPaymentsId(paymentsRepo, pageReqeust);
	}

	@Override
	public Payments save(Payments payments) {
		// TODO Auto-generated method stub
		return payments;
	}

	@Override
	public int getPaymentsCountOfUser(int UserId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findOne(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	}

