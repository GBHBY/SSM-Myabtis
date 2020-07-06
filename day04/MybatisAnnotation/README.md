###全注解开发，但是SqlConfig.xml不会取消，只是代替Mapper.xml
1.在mybatis中针对,CRUD一共有四个注解 ：@Select @Insert @Update @Delete<br>
 - 对于select，使用方式就是直接在方法上写上注解，然后填写sql语句，具体看本项目代码<br>
    - ```
       @Select("select * from user")      
       List<User> findAll();
      ```
     - 注意，如果同时存在注解和mapper.xml，会报错，无论是使用哪种方式来定位dao文件，即：
     是使用`<package/>` 还是`<mapper>` ,就是说，如果选择了注解，对于这个dao，就不能再使用xml方式开发
- 一级缓存是默认存在的,不需要单独配置，具体看官网<br>
```
            User user = userDao.findById(57);
            System.out.println(user);
            User user2 = userDao.findById(57);
            System.out.println(user2);
            System.out.println(user == user2);

//运行结果：
            User{id=57, username='gb', address='黑龙江省佳木斯市', sex='男', birthday=Sun Jun 07 12:21:54 CST 2020}
            User{id=57, username='gb', address='黑龙江省佳木斯市', sex='男', birthday=Sun Jun 07 12:21:54 CST 2020}
            true

```
<br>
二级缓存看代码,或者看视频，自己的代码报错
