package com.GYB.Mybatis.impl;

import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("com.GYB.Mybatis.dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void upDate(User user) {

    }
}
