package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.User;
import com.GYB.Mybatis.impl.UserDaoImpl;
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
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        IUserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);


        }
        in.close();
    }
}
