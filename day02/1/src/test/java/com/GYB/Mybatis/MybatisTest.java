package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    @Test
    public void testFindAll() throws IOException {
//        读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        获取配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        获取SqlSession对象
        SqlSession sqlsession = sqlSessionFactory.openSession();
//        获取代理对象
        IUserDao iUserDao = sqlsession.getMapper(IUserDao.class);
//        执行操作
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        sqlsession.close();

    }

    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setAddress("岑氏");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("那大苏打实打实的");

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        iUserDao.save(user);
        sqlSession.commit();
        List<User> userList = iUserDao.findAll();
        for (User user1 : userList) {
            System.out.println(user1);

        }
        sqlSession.close();

    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setUsername("狂战士");
        user.setSex("男");
        user.setId(48);
        user.setBirthday(new Date());
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        iUserDao.upDate(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
