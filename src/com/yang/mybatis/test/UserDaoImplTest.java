package com.yang.mybatis.test;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yang.mybatis.dao.UserDao;
import com.yang.mybatis.dao.UserDaoImpl;
import com.yang.mybatis.po.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory;
	
	// 在执行测试用例前执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		//MyBatis 配置文件
		String resource = "config/SqlMapConfig.xml";
		
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 创建会话工厂, 传入mybatis的配置文件信息
		sqlSessionFactory = new  SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		// 创建UserDao 的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		// 调用UserDao 的方法
		User user = userDao.findUserById(1);
		
		System.out.println(user);
	}

}
