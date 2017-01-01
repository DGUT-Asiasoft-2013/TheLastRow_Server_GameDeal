package com.cloudage.membercenter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.Company;

@Repository
public interface ICompanyRepository extends PagingAndSortingRepository<Company,Integer>{
	
	@Query("from Company c where c.companyname = ?1")
	Company findCompanyByCompanyName(String companyname);

}
