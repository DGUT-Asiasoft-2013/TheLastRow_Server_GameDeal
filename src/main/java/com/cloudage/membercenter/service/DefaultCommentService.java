package com.cloudage.membercenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Comment;
import com.cloudage.membercenter.repository.ICommentRepository;

@Component
@Service
@Transactional
public class DefaultCommentService implements ICommentService {

	@Autowired
	ICommentRepository commentRepo;

	public Page<Comment> findCommentsOfGood(int goodId, int page) {

		Sort sort = new Sort(Direction.DESC, "createDate");
		PageRequest pageReqeust = new PageRequest(page, 10, sort);
		return commentRepo.findAllOfGoodId(goodId, pageReqeust);
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public int getCommentCountOfGood(int goodId) {
		// TODO Auto-generated method stub
		return commentRepo.commentCountOfGood(goodId);
	}

	
}
