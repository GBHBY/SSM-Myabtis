package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * 在mybatis中针对,CRUD一共有四个注解
 *  @Select @Insert @Update @Delete
 */

//开启二级缓存
@CacheNamespace(blocking =  true)
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value = {
//            property是实体类中的属性，column是数据库中的字段名
            @Result(id = true , property = "id",column = "id"),
            @Result(property = "username",column = "usernmae"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "address",column = "address"),
//            这里面的column是两个表中的相同的列名，比如说，现在是user包含account，那么column就是user中的id
//            下面的select就是accountDao中我们需要的方法的全限定类名
            @Result(property = "accounts",column = "id",many = @Many(select = "com.itheima.dao.IAccountDao.findByUid"
            ,fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 保存用户，
     * 注意：#{username},#{address},#{sex},#{birthday}，这里面都是实体类的属性名称
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{id} ")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user where username like #{username} ")
    @Select("select * from user where username like '%${value}%' ")
    List<User> findUserByName(String username);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();
}
