package com.dcmc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dcmc.mapper.UserMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	UserMapper um;
	
	@Override
	public void signup(String id, String password, String username) {
		// TODO Auto-generated method stub
		System.out.println("id : " + id + " password : " + password + " username: " + username);
		um.addUser(id, password, username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return um.selectUserById(username);
	}

}
