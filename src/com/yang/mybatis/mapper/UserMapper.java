package com.yang.mybatis.mapper;

import java.util.List;

import com.yang.mybatis.po.User;

public interface UserMapper {

	// 根据id查询用户信息 (与对应的        id   parameterType   resultType 一致)
	public User findUserById(int user_id) throws Exception;
	
//	// 根据id查询用户信息
//	public User findUserById(int id) throws Exception;
//	
//	// 根据用户名查询用户列表
//	public List<User> findUserByName(String name) throws Exception;
//	
//	// 添加用户信息
//	public void insertUser(User user) throws Exception;
//	
//	// 删除用户信息
//	public void deleteUser(int id) throws Exception;
	
	
}
