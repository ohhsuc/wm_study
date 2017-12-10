package com.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.User;
import com.learn.dao.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper usermapper;
	
	public User getUserById(Integer id) {
		return usermapper.selectByPrimaryKey(id);
	}

}
