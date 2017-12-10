package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bean.User;
import com.learn.dao.UserMapper;

@Service
public class LoginService {
	
	@Autowired
	private UserMapper usermapper;
	
	public User getPassByName(String username) {
		return usermapper.selectPassByUser(username);
	}
	
	public List<String> getRoleByName(String username){
		return usermapper.selectRoleByUser(username);
	}
	
	public List<String> getPermissionByName(String username){
		return usermapper.selectPermissionByUser(username);
	}
	
}
