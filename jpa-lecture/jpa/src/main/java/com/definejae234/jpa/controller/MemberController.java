package com.definejae234.jpa.controller;

import com.definejae234.jpa.entity.Member;
import com.definejae234.jpa.repository.MemberRepository;
import com.definejae234.jpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signupProcess() {
//        Member member = Member.builder()
//                .userID("definejae234")
//                .userPW("1234")
//                .userName("정재현")
//                .userEmail("definejae234@gmail.com")
//                .build();
        memberService.save();
        return "redirect:/";
    }

    @GetMapping("/login")           // secconfig에 get 방식으로 연결
    public String login() {
        return "member/login";
    }
}
