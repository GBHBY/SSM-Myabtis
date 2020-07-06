package com.GYB.Mybatis.dao;

import com.GYB.Mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAll();
    List<User>  findById(int id);

    void save(User user);

    void upData(User user);



    /**
     * 根据传入条件进行查询
     *
     * @param user 查询条件有可能是名字、地址等
     * @return
     */
    List<User> findUserByCondition(User user);


}
