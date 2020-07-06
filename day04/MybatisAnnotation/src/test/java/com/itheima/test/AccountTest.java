package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        iAccountDao = sqlSession.getMapper(IAccountDao.class);
        sqlSession.commit();
    }
    @Test
    public void testFindAll() {
       List<Account> accountList =  iAccountDao.findAll();
       for(Account account : accountList){
           System.out.println("----------");
           System.out.println(account);
           System.out.println(account.getUser());
       }

    }


    @After
    public void destry() throws IOException {
        in.close();
        sqlSession.close();
    }
}
