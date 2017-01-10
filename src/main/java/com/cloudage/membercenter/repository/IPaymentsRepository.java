package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.cloudage.membercenter.entity.Payments;

public interface IPaymentsRepository extends PagingAndSortingRepository<Payments, Integer> {
	@Query("from Payments payments where payments.user.id = ?1")
	Page<Payments> findAllOfUserId(int UserId, Pageable page);

	@Query("from Payments payments where payments.equipment.id=?1")
	Page<Payments> findAllByEquipmentId(int goodId,Pageable page);
	
	@Query("select count(*) from Payments payments where payments.user.id = ?1")
	int paymentsCountOfUser(int userId);
	
	@Query("from Payments p where (p.state=?1) and (p.equipment.owner.id=?2 or p.user.id=?3)")
	Page<Payments> getPaymentsByState(int state,int authorId,int userId,Pageable page);

	@Query("from Payments p where p.id=?1")
	Payments findPaymentById(int payId);

}
