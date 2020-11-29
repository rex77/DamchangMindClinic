package com.dcmc.service;

public interface UserService {
	//회원가입
	public void signup(String id, String password, String username);
	//로그인은 spring security에서 제공해주는 기능을 이용한다
}
