package com.definejae234.jpa.service;

import com.definejae234.jpa.entity.Member;
import com.definejae234.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    public Member save() {
        Member member = Member.builder()
                .userID("definejae234")
                // 반드시 비밀번호는 암호화 처리
                .userPW(bCryptPasswordEncoder.encode("1234"))   // 암호화
                .userName("정재현")
//                .zipcode("12345")
//                .userAddress("충남 아산시")
                .userEmail("definejae234@gmail.com")
                .build();
        Member insertedMember = memberRepository.save(member);
        // 구현체가 없으며 개발자가 따로 구현하지 않아고 proxy pattern 방식을 통해 구현체 하나를 넣어준다.
        return insertedMember;
    }
}
