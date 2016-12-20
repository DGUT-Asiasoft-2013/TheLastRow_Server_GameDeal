package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Payments;

public interface IPaymentsRepository extends PagingAndSortingRepository<Payments,Integer>{
	@Query("select count(*) from Payments payments where Payments.id.user.id = ?1")
	
	int paymentsCountsOfUsere(int userId);
	
	@Query("select count(*) from Payments payments where Payments.id.user.id = ?1 and Payements.id.user.id = ?2")
	int checkPaymentsExsists(int paymentsId);

	Page<Payments> findAllOfPaymentsId(IPaymentsRepository paymentsRepo, PageRequest pageReqeust); 

}


