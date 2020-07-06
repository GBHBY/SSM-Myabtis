package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IRoleDao;
import com.GYB.Mybatis.dao.IUserDao;
import com.GYB.Mybatis.domain.Role;
import com.GYB.Mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisRoleTest {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IRoleDao iRoleDao = sqlSession.getMapper(IRoleDao.class);
        List<Role> roles = iRoleDao.findAll();
        for (Role role : roles) {
            System.out.println("----------");
            System.out.println(role);
            System.out.println(role.getUsers());
        }

    }

}

