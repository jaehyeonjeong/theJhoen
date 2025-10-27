package com.definejae234.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

// entity
@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Member {

    // 자바의 객체하나만 있어도 데이터베이스와 연동이 가능하다.
    @Id     // 반드시 필요
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;     // primtive 타입을 쓰면 안되고 Object 타입을 사용해야함
//    @Column(unique = true,  nullable = false)
    private String userID;
    private String userName;
    private String userPW;
    private String userEmail;
//    private String userAddress;
//    private String zipcode;
}
