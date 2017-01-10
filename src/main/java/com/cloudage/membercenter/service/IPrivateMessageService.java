package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.PrivateMessage;
import com.cloudage.membercenter.entity.User;

public interface IPrivateMessageService {
	public PrivateMessage save(PrivateMessage privateMessage);

	Page<PrivateMessage> findPrivateMessagesByReveiverId(int receiverId,int senderId, int page);

	 Page<PrivateMessage> getPrivateMessageList(int id, int page);
	Page <User> findAllOtherUsersByNum(String num,int page); 

}
