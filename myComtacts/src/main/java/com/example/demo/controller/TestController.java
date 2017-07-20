package com.example.demo.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.TestRepository;
import com.example.demo.service.TestService;

import scala.annotation.meta.setter;

@RestController
@RequestMapping(value="/")
public class TestController {
	
	private final TestService testService;
	@Autowired
	public TestController(TestService testService, TestRepository testRepository){
		this.testService = testService;
	}
	
	@RequestMapping (method=RequestMethod.GET)
	public String entry () {
		return testService.getName();
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public Object index(){
		return testService.findAll();
	}
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Object findOne(@PathVariable Long id) {
		return testService.findById(id);
	}
	@RequestMapping(value="/user", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	@ResponseBody
	public String create(@RequestBody User user){
		String userId = "";
		try {
			testService.create(user);
			userId = String.valueOf(user.getId());
		}
		catch (Exception ex) {
			return "Error creating the user" + ex.toString();
		}
		return "User is created with id:" + userId;
	}
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable long id) {
		try {
			User user = testService.findById(id);
			testService.delete(user);
		}
		catch (Exception ex) {
			return "Error in deleting  the user" + ex.toString();
		}
		return "User is deleted successfully  with id:" + id;
	}
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON)
	@ResponseBody
	public String update(@RequestBody User user, @PathVariable long id) {
		try {
			 user.setId(id);
			 testService.create(user);
		}
		catch (Exception ex) {
			return "Error in updating  the user" + ex.toString();
		}
		return "User is updated successfully  with id:" + id;
	}
	
}
