package com.example.demo.service;

import com.example.demo.entity.User;

public interface TestService {

	String getName();
	Object findAll();
	User findById (Long id);
	User create (User user);
	void delete (User user);
}
