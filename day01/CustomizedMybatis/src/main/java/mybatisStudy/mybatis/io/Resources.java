package mybatisStudy.mybatis.io;

import java.io.InputStream;

/**
 * 这个是在模仿mybatis自己的Resources类，
 * 根据传入的参数，获取的一个字节输入流
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath) {
//        getClassLoader():是获取类加载器，类加载器是将.class文件加载到JVM内存中，从而能够运行.class文件
//        Resources.class：是获取类的字节码，可以认为getClass()和.class是等价的，但是还是有区别
//              getClass是必须实例化对象后才能使用，但是.class在创建类的时候就已经可以使用了
        return Resources.class.getClassLoader().getResourceAsStream(filePath);

    }
}
