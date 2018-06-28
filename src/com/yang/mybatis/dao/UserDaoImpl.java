package com.yang.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yang.mybatis.po.User;

public class UserDaoImpl implements UserDao {

	// 需要向dao实现类中注入SqlSessionFactory
	// 这里通过构造方法注入
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}


	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("test.findUserById", id);
		
		// 记住要释放资源
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.insertUser", user);
		
		sqlSession.commit();
		
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("test.deleteUser", id);
		
		sqlSession.commit();
		
		sqlSession.close();
	}


	@Override
	public List<User> findUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByName", name);
		
		// 记住要释放资源
		sqlSession.close();
		
		return list;
	}

}
