package com.cloudage.membercenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Comment;


public interface ICommentRepository extends PagingAndSortingRepository<Comment, Integer> {

	@Query("from Comment comment where comment.good.id = ?1")
	Page<Comment> findAllOfGoodId(int goodId, Pageable page);


	@Query("select count(*) from Comment comment where comment.good.id = ?1")
	int commentCountOfGood(int goodId);
}
