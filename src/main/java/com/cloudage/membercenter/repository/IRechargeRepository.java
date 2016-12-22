package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Payments;
import com.cloudage.membercenter.entity.Recharge;



public interface IRechargeRepository  extends PagingAndSortingRepository<Recharge, Integer>{
	@Query("from Recharge recharge where recharge.user.id = ?1")
	
	Page<Recharge> findAllOfUserId(int UserId, Pageable page);


	@Query("select count(*) from Recharge recharge where recharge.user.id = ?1")
	int rechargeCountOfUser(int userId);

}
