package org.scoula.config;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RootConfig.class)
@Log4j
class RootConfigTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("DataSource 연결이 된다.")
    void dataSource() throws SQLException { // DB 연결 테스트
        try (Connection con = dataSource.getConnection()) {
            log.info("DataSource 준비 완료");
            log.info(con);
        }
    }

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void testSqlSessionFactory() {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
                Connection conn = sqlSession.getConnection();
        ) {
            log.info(sqlSession);
            log.info(conn);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}