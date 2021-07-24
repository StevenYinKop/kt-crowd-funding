1. 在子工程中加入搭建环境所需要的具体依赖:
	
具体的依赖和`component`相关

2. 准备jdbc.properties

3. 创建Spring配置文件, 专门配置Spring和MyBatis整合相关的配置

4. 在Spring配置文件中加载jdbc.properties属性文件

5. 配置DataSource

6. 测试从数据源中获取数据库连接

6.1 为了能够使用单元测试, 要将`spring-test`和`junit`依赖加入到`webui`的配置文件中

7. 配置SqlSessionFactoryBean

7.1 装配数据源

7.2 指定Mapper.xml所在的位置

7.3 指定MyBatis全局配置文件的位置

8. 配置MapperScannerConfigurer

9. 测试是否可以装配Mapper接口并且通过这个接口操作数据库