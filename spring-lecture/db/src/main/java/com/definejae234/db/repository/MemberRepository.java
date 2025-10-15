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
        String sql = "SELECT * FROM MEMBER ORDER BY ID";
        //SQL 쿼리 결과(ResultSet)를 지정된 Java 클래스의 인스턴스로 변환
        // query : 복수 건 조외
        List<Member> memberList = jdbctemplate.query(sql, new BeanPropertyRowMapper<>(Member.class));

        return memberList;
    }

    // 조회는 여기에서
    public Member findById(int id) {
        String sql = "SELECT * FROM MEMBER WHERE ID = ?";
        // queryForObject : 단수 건 조외
        return jdbctemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Member.class), id);
    }

    // 데이터 입력 쿼리
    // insert, update, delete : DML(Select 제외)일 경우 int를 return 중요합니다.
    public int save(Member member) {
        // PrepareStatement
        String sql = "insert into member (id, userID, userPW, userName, userEmail) values(member_seq.nextval,?,?,?,?)";
        if(member.getUserPW().isEmpty()) {
            member.setUserPW("1234");
        }
        return jdbctemplate.update(sql, member.getUserID(), member.getUserPW(), member.getUserName(), member.getUserEmail());
    }

    public int update(Member member) {
        String sql = "update member set userName=?, userEmail=? where id=?";
        System.out.println("update data = " + member.getId() + ", " + member.getUserName() + ", " + member.getUserEmail() );
        return jdbctemplate.update(sql, member.getUserName(), member.getUserEmail(), member.getId());
    }

    public int delete(Member member) {
        String sql = "delete from member where id=? AND userPW=?";
        System.out.println("MemberRepository.deleteID = " + member.getId());
//        System.out.println("MemberRepository.deleteUserID = " + member.getUserID());
        System.out.println("MemberRepository.deleteUserPW = " + member.getUserPW());
//        return jdbctemplate.update(sql, member.getId(), member.getUserID(), member.getUserPW());
        return jdbctemplate.update(sql, member.getId(), member.getUserPW());
    }
}
