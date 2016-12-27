package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Inbox;
import com.cloudage.membercenter.entity.InboxList;
import com.cloudage.membercenter.repository.IInboxListRepository;
import com.cloudage.membercenter.repository.IInboxRepository;

@Component
@Service
@Transactional
public class DefaultInboxService implements IInboxService{
	
	@Autowired
	IInboxRepository inboxRepo;
	
	@Autowired
	IInboxListRepository inboxListRepo;
	
	
	@Override
	public Inbox save(Inbox inbox){
		return inboxRepo.save(inbox);
	}
	
	@Override
	public InboxList save(InboxList inboxList){
		return inboxListRepo.save(inboxList);
	}
	
	@Override
	public InboxList findBySign(String sign){
		return inboxListRepo.findInboxListBySign(sign);
	}
	
//	@Override
//	public Page<Inbox> findAllInbox(String name, int i) {
//		Sort sort = new Sort(Direction.DESC, "createDate");
//		PageRequest request = new PageRequest(i, 10, sort);
//		return inboxRepo.findAllInbox(name, request);
//	}
	

	@Override
	public Page<Inbox> inboxGetChat(String text, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest request = new PageRequest(page, 10, sort);
		return inboxRepo.inboxGetChat(text, request);
	}
	
	@Override
	public Page<InboxList> findInboxList(String text, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest request = new PageRequest(page, 10, sort);
		return inboxListRepo.findInboxList(text, request);
	}
}