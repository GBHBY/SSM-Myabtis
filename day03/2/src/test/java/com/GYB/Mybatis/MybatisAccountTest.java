package com.GYB.Mybatis;

import com.GYB.Mybatis.dao.IAccount;
import com.GYB.Mybatis.domain.Account;
import com.GYB.Mybatis.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisAccountTest {
    @Test
    public void testFindAll() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccount iAccount = sqlSession.getMapper(IAccount.class);
        List<Account> accounts = iAccount.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindAllUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccount iAccount = sqlSession.getMapper(IAccount.class);
        List<Account> accounts = iAccount.findAll();
        for (Account account : accounts) {
            System.out.println("每个account的信息");
            System.out.println(account);

        }

    }

    /**
     * 方法报错，原因不知
     *
     * @throws IOException
     */
    @Test
    public void testFindAllAccount() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IAccount iAccount = sqlSession.getMapper(IAccount.class);
        List<AccountUser> accountUsers = iAccount.findAllAccount();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }

    }


}


























