package com.GYB.Mybatis.dao;

import com.GYB.Mybatis.domain.Account;

import java.util.List;

public interface IAccount {
    /**
     * 查询所有账户
     */
    List<Account> findAll();
    List<Account> findAllByUserId ();


}
