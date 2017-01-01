package com.cloudage.membercenter.service;

import java.util.List;

import com.cloudage.membercenter.entity.Company;

public interface ICompanyService {

	Company findByCompanyName(String name);
	
	List<Company> getAllCompany();
}
