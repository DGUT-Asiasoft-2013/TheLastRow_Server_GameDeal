package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Inbox;
import com.cloudage.membercenter.entity.InboxList;

public interface IInboxService {

	Inbox save(Inbox inbox);
	
	InboxList save(InboxList inboxList);

//	Page<Inbox> findAllInbox(String name, int i);
	
	Page<Inbox> inboxGetChat(String text, int page);

	Page<InboxList> findInboxList(String text, int page);

	InboxList findBySign(String sign);
}