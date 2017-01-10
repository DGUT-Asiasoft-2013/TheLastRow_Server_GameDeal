package com.cloudage.membercenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudage.membercenter.entity.Company;
import com.cloudage.membercenter.repository.ICompanyRepository;

@Component
@Service
@Transactional
public class DefaultCompanyService implements ICompanyService {
	
	@Autowired
	ICompanyRepository companyRepo;

	@Override
	public Company findByCompanyName(String companyname) {
		return companyRepo.findCompanyByCompanyName(companyname);
	}

	@Override
	public List<Company> getAllCompany() {
		Sort sort = new Sort(Direction.ASC,"id");
		return (List<Company>) companyRepo.findAll(sort);
	}

}
