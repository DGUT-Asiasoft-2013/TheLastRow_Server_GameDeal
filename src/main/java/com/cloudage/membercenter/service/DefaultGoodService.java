package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.IArticleRepository;
import com.cloudage.membercenter.repository.IGoodRepository;

@Component
@Service
@Transactional

public class DefaultGoodService implements IGoodService {
	
	
	@Autowired
	IGoodRepository goodRepo;

	@Override
	public Good findOne(int id) {
		
		return goodRepo.findOne(id);
	}

	@Override
	public List<Good> findAllByAuthor(User user) {
		// TODO Auto-generated method stub
		return goodRepo.findAllByAuthor(user);
	}

	
	public List<Good> findAllByAuthorId(Integer userId) {
		// TODO Auto-generated method stub
		return goodRepo.findAllByAuthorId(userId);
	}

	@Override
	public Good save(Good good) {
		// TODO Auto-generated method stub
		return goodRepo.save(good);
	}

	@Override
	public Page<Good> getFeeds(int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return goodRepo.findAll(pageRequest);
	}

	@Override
	public Page<Good> searchEquipWithKeyword(String keyword, int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageRequest = new PageRequest(page, 10, sort);
		return goodRepo.searchEquipWithKeyword(keyword, pageRequest);
	}
	
	

}
