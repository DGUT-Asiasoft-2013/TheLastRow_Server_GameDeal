package com.cloudage.membercenter.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudage.membercenter.entity.Inbox;
import com.cloudage.membercenter.entity.InboxList;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.service.IInboxService;
import com.cloudage.membercenter.service.IUserService;


@RestController
@RequestMapping("/api")
public class InboxController {
	
	
	@Autowired
	IInboxService inboxService;
	
	@Autowired
	IUserService userService;
	

	
	@RequestMapping(value="/addInbox", method=RequestMethod.POST)
	public Inbox addInbox(
			@RequestParam String content,
			@RequestParam String sendname,	
			HttpServletRequest request
			){
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间

		Inbox inbox=new Inbox();
		inbox.setInboxContent(content);
		inbox.setSenduser(getUser(sendname));
		inbox.setIsread(false);
		inbox.setCreateDate(curDate);

		
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		
		
		User user =userService.findById(uid);
		if(user!=null){
			inbox.setRecuser(getUser(user.getName()));
		}else{
			//服务器无登陆状态
		}
		String sign;
		if(user.getName().compareTo(sendname)>0)
			sign=sendname+"-"+user.getName();
		else
			sign=user.getName()+"-"+sendname;
		inbox.setSign(sign);
		
		Inbox return_inbox = inboxService.save(inbox);
		InboxList inboxList=inboxService.findBySign(sign);
		if (inboxList==null) {
			inboxList=new InboxList();
			inboxList.setLast_inbox(inbox);
			inboxList.setSendname(sendname);
			inboxList.setRecname(user.getName());
			inboxList.setSign(sign);
			inboxList.setCreateDate(curDate);
			inboxService.save(inboxList);
		} else {
			inboxList.setLast_inbox(inbox);
			inboxList.setCreateDate(curDate);
			inboxService.save(inboxList);
		}
		return return_inbox;
		
	}
	

	@RequestMapping(value="/inbox",method=RequestMethod.GET)
	public Page<InboxList> getInbox( HttpServletRequest request){
		return getInbox(0, request);

	}

	@RequestMapping(value="/inbox/{page}",method=RequestMethod.GET)
	public Page<InboxList> getInbox(
			@PathVariable int page,
			HttpServletRequest request
			){
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		User user =userService.findById(uid);
		
		return inboxService.findInboxList(user.getName(),page);

	}
	
	@RequestMapping(value="/inboxGetOne",method=RequestMethod.GET)
	public InboxList getInboxOne(
			@PathVariable String sign,
			HttpServletRequest request){
		return inboxService.findBySign(sign);

	}
	
	@RequestMapping(value="/inboxgetchat", method=RequestMethod.POST)
	public Page<Inbox> inboxGetChat(
			@RequestParam  String text,
			HttpServletRequest request
			){
		
		return inboxGetChat(text,0,request);

	}

	@RequestMapping(value="/inboxgetchat/{page}", method=RequestMethod.POST)
	public Page<Inbox> inboxGetChat(
			@RequestParam  String name,
			@PathVariable  int page,
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		Integer uid = (Integer) session.getAttribute("uid");
		
		
		User user =userService.findById(uid);
		String sign;
		if(user.getName().compareTo(name)>0)
			sign=name+"-"+user.getName();
		else
			sign=user.getName()+"-"+name;
		return inboxService.inboxGetChat(sign,page);
	}
	
	@RequestMapping(value = "/getUser", method=RequestMethod.GET)
	public User getUser(
			@RequestParam  String name
			){
		return userService.findByName(name);
	}
	
}