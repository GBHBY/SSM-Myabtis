package mybatisStudy.mybatis.SqlSession;

/**
 * 通过这个来创建userDao的代理对象
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
