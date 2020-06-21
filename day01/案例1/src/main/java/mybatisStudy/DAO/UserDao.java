package mybatisStudy.DAO;

import mybatisStudy.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
}
