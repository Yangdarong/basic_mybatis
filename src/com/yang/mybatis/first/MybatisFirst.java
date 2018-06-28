package com.yang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yang.mybatis.po.User;

public class MybatisFirst {
	
	// 根据id查询用户信息:得到一条记录结束
	@Test
	public void findUserByIdTest() throws IOException {
		
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		// 通过工厂得到SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 通过SqlSession操作数据库
		// parameter 指定类型参数
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(user);
		
		// 释放资源
		sqlSession.close();
	}
	
	// 根据用户名称 模糊查询
	@Test
	public void findUserByNameTest() throws IOException {
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		// 通过工厂得到SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> result = sqlSession.selectList("test.findUserByName", "m");
				
		System.out.println(result);
		
		sqlSession.close();
	}
	
	// 添加用户
	@Test
	public void insertUserTest() throws IOException {
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		// 通过工厂得到SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUser_name("tony");
		user.setUser_passwd("123");
		user.setUser_privilege(0);
		
		sqlSession.insert("test.insertUser", user);
		
		//需要手动提交
		sqlSession.commit();
		
		// 获取用户ID
		System.out.println(user.getUser_id());
		
		sqlSession.close();
	}
	
	// 删除用户
	@Test
	public void deleteUserTest() throws IOException {
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		// 通过工厂得到SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("test.deleteUser", 5);
		
		//需要手动提交
		sqlSession.commit();
		
		sqlSession.close();
	}
	
	// 更新用户
	@Test
	public void updateUserTest() throws IOException {
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
		// 通过工厂得到SqlSession 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUser_id(3);
		user.setUser_name("ityang");
		user.setUser_passwd("1234");
		user.setUser_privilege(0);
		
		sqlSession.update("test.updateUser", user);
		
		//需要手动提交
		sqlSession.commit();
		
		sqlSession.close();
	}
}
