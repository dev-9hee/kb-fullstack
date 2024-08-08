package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.fail;

@Configuration
@SpringJUnitConfig
@ContextConfiguration(classes = RootConfig.class)
@Slf4j
@PropertySource("classpath:application.properties")
class RootConfigTest {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Test
    public void testSqlSessionFactory() {
        try (SqlSession session = sqlSessionFactory.openSession();
             Connection con = session.getConnection()) {
            log.info("SqlSession: {}", session);
            log.info("Connection: {}", con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}


