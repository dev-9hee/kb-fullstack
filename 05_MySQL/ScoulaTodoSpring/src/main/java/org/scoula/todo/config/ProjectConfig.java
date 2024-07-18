package org.scoula.todo.config;

import org.scoula.todo.common.JDBCUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@ComponentScan({"org.scoula.todo", "org.scoula.travel"})
public class ProjectConfig { // 스프링 설정 파일

    @Bean
    Connection conn() throws Exception {
        Properties properties = new Properties();
        properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String id = properties.getProperty("id");
        String password = properties.getProperty("password");

        Class.forName(driver);
        return DriverManager.getConnection(url, id, password);
    }

}
