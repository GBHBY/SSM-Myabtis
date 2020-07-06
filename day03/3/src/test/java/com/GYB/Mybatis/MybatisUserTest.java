package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IRoleDao;
import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.Role;
import com.GYB.Mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisUserTest {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
        List<User> users = iUserDao.findAll();
        for (User user : users) {
            System.out.println("----------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }

    }

}
