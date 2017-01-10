package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.PrivateMessage;
import com.cloudage.membercenter.entity.User;
@Repository
public interface IPrivateMessageRepository extends PagingAndSortingRepository<PrivateMessage, Integer>{
	@Query("from PrivateMessage p where (p.privateMessageReceiver.id = ?1  and p.privateMessageSender.id = ?2) or (p.privateMessageReceiver.id = ?2  and p.privateMessageSender.id = ?1)")
	Page<PrivateMessage> findPrivateMessageByReceiverId(int receiverId,int senderId,Pageable page);

	
	@Query("from PrivateMessage p where p.privateMessageReceiver.id=?1 or p.privateMessageSender.id = ?1")
	Page<PrivateMessage> findPrivateMessageListBySenderId(int id, Pageable page);

	@Query("from User u where u.account !=?1")
	Page<User> findAllOtherUserByNum(String num,Pageable page);
}