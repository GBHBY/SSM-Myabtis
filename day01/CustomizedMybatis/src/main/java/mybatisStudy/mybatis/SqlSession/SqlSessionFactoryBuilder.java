package mybatisStudy.mybatis.SqlSession;

import mybatisStudy.mybatis.SqlSession.cfg.Configuration;
import mybatisStudy.mybatis.SqlSession.defaults.DefaultSqlsessionFactory;
import mybatisStudy.mybatis.utils.XMLConfigBuilder;
import sun.security.krb5.Config;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlsessionFactory(configuration);


    }
}
