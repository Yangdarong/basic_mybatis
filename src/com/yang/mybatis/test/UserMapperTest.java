package com.yang.mybatis.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yang.mybatis.mapper.UserMapper;
import com.yang.mybatis.po.User;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		// MyBatis 配置文件
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 创建UserMapper 对象 MyBatis 自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		// 调用userMapper的方法
		User user = userMapper.findUserById(1);
		
		System.out.println(user);
		
	}

}
