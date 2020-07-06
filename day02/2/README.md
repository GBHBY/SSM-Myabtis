这个项目主要是学习了，jdbc配置文件，以及配置别名的两个标签
   ` <typeAliases>
            <!--  <typeAlias type="com.GYB.Mybatis.domain.User" alias="user"></typeAlias>-->
            <!--这个标签，用于指定要配置别名的包，一旦指定，该包下所有的实体类都会注册别名，并且类名就是别名，不再区分大小写-->
            <package name="com.GYB.Mybatis.domain"/>
        </typeAliases>`