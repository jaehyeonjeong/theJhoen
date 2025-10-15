package com.definejae234.db.controller;

import com.definejae234.db.dto.Member;
import com.definejae234.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository  memberRepository;

    @GetMapping("/member/list")
    public String memberList(Model model){
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList",memberList);
        return "member/list";
    }

    @GetMapping("/member/detail/{id}")
    public String memberList(@PathVariable("id") int id, Model model){
        Member findedMember = memberRepository.findById(id);
        model.addAttribute("findMember",findedMember);
        return "member/detail";
    }
}
