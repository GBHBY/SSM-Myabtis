package mybatisStudy.mybatis.SqlSession.defaults;

import mybatisStudy.mybatis.SqlSession.SqlSession;
import mybatisStudy.mybatis.SqlSession.SqlSessionFactory;
import mybatisStudy.mybatis.SqlSession.cfg.Configuration;
import sun.security.krb5.Config;

public class DefaultSqlsessionFactory implements SqlSessionFactory {
    private Configuration configuration;
    public DefaultSqlsessionFactory(Configuration configuration){
        this.configuration = configuration;
    }

    /**
     * 用于创建一个新的数据库操作对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return null;
    }
}
