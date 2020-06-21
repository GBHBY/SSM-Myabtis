package mybatisstudy.dao;

import mybatisstudy.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
/**
* @direction:
* @params:
* @return: java.util.List<domain.User>
* @Author: GB
* @Date: 2020/5/5 15:25
*/
    @Select("select * from user")
    List<User> findAll();
}
