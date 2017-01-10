package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;


import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.User;

public interface IPaymentsService {

	Page<Payments> findPaymentsOfUser(int UserId, int page);

	Payments save(Payments payments);

	int getPaymentsCountOfUser(int UserId);

	Page<Payments> getPaymentsByState(int state,int authorId,int userId,int page);
	
	Payments findPaymentsById(int payId);
}