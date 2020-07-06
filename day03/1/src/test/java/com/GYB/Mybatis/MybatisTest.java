package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.QueryVo;
import com.GYB.Mybatis.domain.User;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {

    /*@Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        IUserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);


        }
        in.close();
    }
    */

    @Test
    public void testSave() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User("剑神", "地下城与勇士", "男", new Date());
        iUserDao.save(user);
//        sqlSession.commit();
        sqlSession.close();
        in.close();


    }

    @Test
    public void testFindById() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> user = iUserDao.findById(53);
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    @Test
    public void testUpData() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User("黑暗君主", "地下城与勇士", "男", new Date());
        user.setId(52);
        iUserDao.upData(user);

        List<User> users = iUserDao.findAll();
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
        inputStream.close();


    }

    @Test
    public void testFindUserByCondition() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("gyb");
        user.setSex("女");
        List<User> users = iUserDao.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
        in.close();
    }

    @Test
    public void testfindUserByIds() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(45);
        list.add(47);
        vo.setIds(list);

        List<User> users = iUserDao.findUserByIds(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
        in.close();
    }


}


























