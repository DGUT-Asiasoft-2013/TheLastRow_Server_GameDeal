package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;



public class IRechargeRepository {
	@Query("from Recharge recharge where recharge.user.id = ?1")
	
	Page<Recharge> findAllOfUserId(int UserId, Pageable page);


	@Query("select count(*) from Recharge recharge where recharge.user.id = ?1")
	int rechargeCountOfUser(int userId);

}
