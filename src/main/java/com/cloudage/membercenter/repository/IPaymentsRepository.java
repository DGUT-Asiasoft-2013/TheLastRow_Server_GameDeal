package com.cloudage.membercenter.repository;

import org.springframework.data.jpa.repository.Query;

public class IPaymentsRepository {
	@Query("select count(*) from Payments payments where Payments.id.user.id = ?1")
	
	int paymentsCountsOfUsere(int userId);
	
	@Query("select count(*) from Payments payments where Payments.id.user.id = ?1 and Payements.id.user.id = ?2")
	int checkPaymentsExsists(int paymentsId); 

}


