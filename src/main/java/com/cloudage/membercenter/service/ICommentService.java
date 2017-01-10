package com.cloudage.membercenter.service;

import org.springframework.data.domain.Page;

import com.cloudage.membercenter.entity.Comment;

public interface ICommentService {
	Page<Comment> findCommentsOfGood(int goodId, int page);

	Comment save(Comment comment);

	int getCommentCountOfGood(int goodId);
}