package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.PrivateMessage;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IPrivateMessageRepository;
import com.cloudage.membercenter.repository.IUserRepository;
@Component
@Service
@Transactional
public class DefaultPrivateMessage implements IPrivateMessageService {

	@Autowired
	IPrivateMessageRepository iPrivateMessageRepo;

	@Override
	public PrivateMessage save(PrivateMessage privateMessage) {

		return	 iPrivateMessageRepo.save(privateMessage);
	}
	@Override
	public Page<PrivateMessage> findPrivateMessagesByReveiverId(int receiverId,int senderId,int page) {
		Sort sort =new Sort(Direction.DESC,"createDate");
		PageRequest pageRequest=new PageRequest(page, 20, sort);
		return iPrivateMessageRepo.findPrivateMessageByReceiverId(receiverId,senderId,pageRequest);
	}
	@Override
	public Page<PrivateMessage> getPrivateMessageList(int id , int page) {
		Sort sort =new Sort(Direction.DESC,"createDate");
		PageRequest pageRequest=new PageRequest(page,30, sort);
		return iPrivateMessageRepo.findPrivateMessageListBySenderId(id,pageRequest);
	}
	@Override
	public Page<User> findAllOtherUsersByNum(String num , int page) {
		Sort sort =new Sort(Direction.ASC,"account");
		PageRequest pageRequest=new PageRequest(page,30, sort);
		return iPrivateMessageRepo.findAllOtherUserByNum(num,pageRequest);
	}

}