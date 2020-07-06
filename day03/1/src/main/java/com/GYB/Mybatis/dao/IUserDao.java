package com.GYB.Mybatis.dao;

import com.GYB.Mybatis.domain.QueryVo;
import com.GYB.Mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    void save(User user);

    void upData(User user);

    List<User> findById(int id);

    /**
     * 根据传入条件进行查询
     *
     * @param user 查询条件有可能是名字、地址等
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据QueryVo 中的id集合，来查询用户信息
     *
     * @param vo
     * @return
     */
    List<User> findUserByIds(QueryVo vo);
}
