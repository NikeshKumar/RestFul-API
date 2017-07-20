package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	// @Override
	public String getName(){
		return "Hi Nikesh";
	}
	@Autowired
	private TestRepository testRepository;
	
	public Object findAll() {
		return testRepository.findAll();
	}
	
	public User findById (Long id) {
		return testRepository.findOne(id);
	}
	
	public User create (User user) {
		return testRepository.save(user);
	}
	public void delete (User user) {
		 testRepository.delete(user);
		 return;
	}
	
	
}
