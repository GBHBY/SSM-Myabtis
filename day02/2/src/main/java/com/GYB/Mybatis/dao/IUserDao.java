package com.GYB.Mybatis.dao;

import com.GYB.Mybatis.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void save(User user);
    void upDate(User user);
}
