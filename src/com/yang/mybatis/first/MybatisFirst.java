package com.yang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

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
}
