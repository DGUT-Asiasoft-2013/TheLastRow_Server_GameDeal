package com.cloudage.membercenter.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.Likes;
import com.cloudage.membercenter.entity.User;

public interface ILikesService {

	void addLike(User user, Good good);

	void removeLike(User user, Good good);

	int countLikes(int goodId);

	boolean checkLiked(int userId, int goodId);
	

	Page<Likes> getLikesByUserId(int userId, int page);

}