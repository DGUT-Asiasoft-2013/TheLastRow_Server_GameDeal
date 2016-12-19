package com.cloudage.membercenter.service;


import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.User;

public class IPaymentsService {


	void addPayments(User user, Payments payments);
	void removePayments(User user,Payments payments);
	int countPayments(int userId);
	boolean checkPayed(int paymentsId);
}
