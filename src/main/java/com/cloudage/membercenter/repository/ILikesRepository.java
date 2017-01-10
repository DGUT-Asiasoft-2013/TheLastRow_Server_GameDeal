package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Likes;

@Repository
public interface ILikesRepository extends PagingAndSortingRepository<Likes, Likes.Key> {

	@Query("select count(*) from Likes likes where likes.id.good.id = ?1")
	int likeCountsOfGood(int goodId);

	@Query("select count(*) from Likes likes where likes.id.user.id = ?1 and likes.id.good.id = ?2")
	int checkLikesExsists(int authorId, int goodId);
	
	@Query("from Likes likes where likes.id.user.id=?1")
	Page<Likes> getLikesByUserID(int user_id,Pageable pageable);

}

