package com.definejae234.db.repository;

import com.definejae234.db.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//자동 스캔 어노테이션
@Repository
@RequiredArgsConstructor    // 생성자 주입을 간편하게 함. public MemberRepository(JdbcTemplate template) <- 이거 안해도 됨)
public class MemberRepository {
    // DI, IOC 방식
    // 새터 주입 방식, 필드 주입 방식
//    @Autowired
//    JdbcTemplate jdbcTemplate;

    // 생성자 주입 방식
    private final JdbcTemplate jdbctemplate;
//    public MemberRepository(JdbcTemplate jdbctemplate) {
//        this.jdbctemplate = jdbctemplate;
//    }

    public List<Member> findAll() {
        String sql = "SELECT * FROM MEMBER";
        //SQL 쿼리 결과(ResultSet)를 지정된 Java 클래스의 인스턴스로 변환
        List<Member> memberList = jdbctemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));

        return memberList;
    }
}
