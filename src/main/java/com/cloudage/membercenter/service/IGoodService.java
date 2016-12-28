package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.User;

public interface IGoodService {

	Good findOne(int id);


	List<Good> findAllByAuthor(User user);

	List<Good> findAllByAuthorId(Integer userId);

	Good save(Good good);

	Page<Good> getFeeds(int page);

	Page<Good> searchEquipWithKeyword(String keyword, int page);
}
