package com.example.demo.core.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: whydda
 * Date: 2020-01-15
 * Time: 오후 2:57
 */
@Slf4j
@Component
public class InitializationDB implements CommandLineRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void run(String... args) throws Exception {
                /*
        java 1.8에 업데이트된 try-resource 문법으로
        이와 같이 진행하면, try안에서 사용한 자원을 사용한 후 자동으로 제거(삭제)된다.
         */
        try (Connection connection = dataSource.getConnection()) {
            StringBuilder sql = new StringBuilder();

            // table 생성
            Statement statement3 = connection.createStatement();
            sql.append("CREATE TABLE t_user (\n" +
                    "    user_id VARCHAR2(20) NOT NULL, /* 아이디 */\n" +
                    "    password VARCHAR2(20) NOT NULL, /* 패스워드 */\n" +
                    "    user_name VARCHAR2(50) NOT NULL /* 이름 */\n" +
                    ")");
            statement3.executeUpdate(sql.toString());

            jdbcTemplate.execute("INSERT INTO users VALUES ('whydda', '1234', '변진환')");
        }

        log.info("테이블 등록 완료.");
    }
}
