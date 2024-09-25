package com.boyer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class EcoGuardianbackendSpringbootApplicationTests {

    @Autowired(required = false)
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看默认数据源class com.zaxxer.hikari.HikariDataSource :
        System.out.println(dataSource.getClass());

        //获得数据库链接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //xxxx Template : springboot 已经配置好的模板bean,拿来即用

        //关闭数据库链接
        connection.close();

    }

}
