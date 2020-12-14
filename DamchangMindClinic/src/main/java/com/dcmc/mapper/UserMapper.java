package com.dcmc.mapper;

import org.apache.ibatis.annotations.Param;

import com.dcmc.domain.UserDTO;

public interface UserMapper {
	public void addUser(@Param("id") String id,@Param("password") String password,@Param("username") String username);
	public UserDTO selectUserById(String id);
}
