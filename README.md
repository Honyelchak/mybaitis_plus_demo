## Mybatis-Plus-demo

### 快速开始：
- 导入依赖(尽量不要同时导入Mybatis和Mybatis-Plus，可能会有版本差异)
```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.3.1.tmp</version>
</dependency>
```
- 配置数据库
```properties
# mysql5驱动为com.mysql.jdbc.Driver(高版本兼容低版本)
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=GMT%2B8&characterEncoding=UTF8
spring.datasource.username=root
spring.datasource.password=root
```
- 继承BaseMapper<T>接口
```java
@Repository
public interface UserMapper extends BaseMapper<User> {
}
```
- 在主启动类上开启Mapper扫描
```java
@MapperScan("com.yjz.mp.demo.mapper")
public class DemoApplication {
    // 省略......
}
```

### 配置日志
配置日志之后，我们可以看到sql是如何执行的：
```properties
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```
![img01](img/img01.png)

### CURD
CRUD就不再展示，总之`extends`BaseMapper之后，能够实现很多基本的增删改查操作。

说几个细节部分：

#### 主键生成策略





