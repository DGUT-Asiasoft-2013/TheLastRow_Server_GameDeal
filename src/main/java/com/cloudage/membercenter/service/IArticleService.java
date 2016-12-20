package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.User;

public interface IArticleService {
	Article findOne(int id);
	List<Article> findAllByAuthor(User user);
	List<Article> findAllByAuthorId(Integer userId);
	Article save(Article article);
	
	Page<Article> getFeeds(int page);
}
