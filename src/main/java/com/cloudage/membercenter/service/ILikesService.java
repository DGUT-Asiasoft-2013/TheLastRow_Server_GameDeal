package com.cloudage.membercenter.service;


import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.User;

public interface ILikesService {

	void addLike(User user, Good good);

	void removeLike(User user, Good good);

	int countLikes(int goodId);

	boolean checkLiked(int userId, int goodId);

}
