package com.cloudage.membercenter.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IUserRepository;

@Component
@Service
@Transactional
public class DefaultUserService implements IUserService {

	@Autowired
	IUserRepository userRepo;

	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findByAccount(String account) {
		return userRepo.findUserByAccount(account);
	}

	@Override
	public User findById(Integer id) {
		return userRepo.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findUserByEmail(email);
	}
}
