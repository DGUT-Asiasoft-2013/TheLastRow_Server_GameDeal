package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.Likes;
import com.cloudage.membercenter.entity.Likes.Key;
import com.cloudage.membercenter.entity.User;
import com.cloudage.membercenter.repository.ILikesRepository;

@Component
@Service
@Transactional
public class DefaultLikesService implements ILikesService {

	@Autowired
	ILikesRepository likesRepo;


	@Override
	public void addLike(User user, Good good) {
		Likes.Key key = new Key();
		key.setUser(user);
		key.setGood(good);

		Likes lk = new Likes();
		lk.setId(key);
		likesRepo.save(lk);
	}

	@Override
	public void removeLike(User user, Good good) {
		Likes.Key key = new Key();
		key.setUser(user);
		key.setGood(good);

		likesRepo.delete(key);
	}

	@Override
	public int countLikes(int goodId) {
		return likesRepo.likeCountsOfGood(goodId);
	}

	@Override
	public boolean checkLiked(int userId, int goodId) {
		return likesRepo.checkLikesExsists(userId, goodId) > 0;

	
	
	}

	public Page<Likes> getLikesByUserId(int userId,int page) {
		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page, 10, sort);
		return likesRepo.getLikesByUserID(userId,pageReqeust);
	}


}