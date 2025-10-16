package com.definejae234.validation.repository;

import com.definejae234.validation.dto.LoginDto;
import com.definejae234.validation.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    // 생성자 주입 방식
    private final JdbcTemplate jdbcTemplate;

    public MemberDto findById(LoginDto loginDto) {
        String sql = "select * from member where userid = ? and userpw = ?";
//        System.out.println("memberRepository.findById() : " +);
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(MemberDto.class),
                loginDto.getUserID(),
                loginDto.getUserPW());
    }
}
