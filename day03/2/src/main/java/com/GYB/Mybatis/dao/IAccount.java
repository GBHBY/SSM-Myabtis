package com.GYB.Mybatis.dao;

import com.GYB.Mybatis.domain.Account;
import com.GYB.Mybatis.domain.AccountUser;

import java.util.List;

public interface IAccount {
    /**
     * 查询所有账户
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有账户名称和地址信息，注意sql语句的写法
     * @return
     */
    List<AccountUser> findAllAccount();
}
