package com.cloudage.membercenter.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cloudage.membercenter.entity.Article;
import com.cloudage.membercenter.entity.Good;
import com.cloudage.membercenter.entity.User;

public interface IGoodRepository extends PagingAndSortingRepository<Good, Integer>{

	@Query("from Good g where g.author = ?1")
	List<Good> findAllByAuthor(User user);

	@Query("from Good g where g.author.id = ?1")
	List<Good> findAllByAuthorId(Integer userId);

	@Query("from Good g where g.game_equip like %?1%")
	Page<Good> searchEquipWithKeyword(String keyword, Pageable page);
}
