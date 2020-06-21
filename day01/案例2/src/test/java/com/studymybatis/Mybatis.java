package com.studymybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mybatisstudy.dao.UserDao;
import mybatisstudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author ：GB
 * @date ：Created in 2020/5/5 15:57
 * @description：测试
 * @modified By：
 * @version: 1$
 */

public class Mybatis {
    public static void main(String[] args) throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);

        }
        sqlSession.clearCache();
        in.close();

    }
}
