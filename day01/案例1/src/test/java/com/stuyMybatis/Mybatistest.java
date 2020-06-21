package com.stuyMybatis;

import mybatisStudy.DAO.UserDao;
import mybatisStudy.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Mybatistest {

    public static void main(String[] args) throws IOException {
//        读取配置文件
        InputStream in = Resources.getResourceAsStream("Sqlmapconfig.xml");
//        **创建SqlSessionFactory 注意：SqlSessionfactory是个接口，不能创建对象
//        但是mybatis准备了SqlSesionfactorybuilder，通过这个来创建builder，可以比喻成一个包工头，让包工头来创建factory，我们只需要把‘in’提供给builder就可以，这就是构建者模式
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        使用工厂生产SqlSession对象，findALL方法没有进行实现，工厂模式
        SqlSession sqlSession = factory.openSession();
//        使用SqlSeesion创建DAO接口的代理对象，
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
//        释放资源
        sqlSession.close();
        in.close();

    }
}
