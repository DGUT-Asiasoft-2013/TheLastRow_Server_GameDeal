package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.InboxList;

public interface IInboxListRepository extends PagingAndSortingRepository<InboxList, Integer> {

	@Query("FROM InboxList inboxlist WHERE inboxlist.recname = ?1 OR inboxlist.sendname = ?1")
	Page<InboxList> findInboxList(String name, Pageable request);
	
	@Query("from InboxList inboxlist where inboxlist.sign = ?1")
	InboxList findInboxListBySign(String sign);
	
}