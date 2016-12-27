package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Inbox;

public interface IInboxRepository extends PagingAndSortingRepository<Inbox, Integer> {

	// @Query("select ibx1.id as from Inbox ibx1 where ibx1.id = ?1")
//	@Query("FROM Inbox inbox1 WHERE inbox1.rec_name = ?1 OR inbox1.send_name = ?1 ")
//	Page<Inbox> findAllInbox(String name, Pageable request);

	@Query("FROM Inbox inbox WHERE inbox.sign = ?1 order by inbox.createDate desc")
	Page<Inbox> inboxGetChat(String name, Pageable request);
}