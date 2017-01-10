package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IPaymentsRepository;
@Component
@Service
@Transactional
public class DefaultPaymentsService implements IPaymentsService {
	@Autowired
	IPaymentsRepository paymentsRepo;

	public Page<Payments> findPaymentsOfUser(int userId, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page, 10, sort);
		return paymentsRepo.findAllOfUserId(userId, pageReqeust);
	}

	@Override
	public Payments save(Payments payments) {
		return paymentsRepo.save(payments);
	}

	@Override
	public int getPaymentsCountOfUser(int userId) {
		return paymentsRepo.paymentsCountOfUser(userId);
	}

	@Override
	public Page<Payments> getPaymentsByState(int state,int authorId,int userId,int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page, 10, sort);
		return paymentsRepo.getPaymentsByState(state,authorId,userId,pageReqeust);
	}

	@Override
	public Payments findPaymentsById(int payId) {
		return paymentsRepo.findPaymentById(payId);
	}

}

