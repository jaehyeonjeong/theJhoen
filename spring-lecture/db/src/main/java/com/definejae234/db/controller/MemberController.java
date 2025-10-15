package com.definejae234.db.controller;

import com.definejae234.db.dto.Member;
import com.definejae234.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // Get/Post 둘다 사용할 수 있다.
    @GetMapping("/member/add")
    public String memberAdd(Model model){
        // add.html 출력
        return "member/add";
    }

    @PostMapping("/member/add")
//    @ResponseBody
    public String memberAdd(@ModelAttribute Member member){
//        System.out.println(member.getUserID()+"==="+
//                member.getUserName()+"==="+
//                member.getUserEmail());
        int result = memberRepository.save(member);
        System.out.println(result);
        return "redirect:../member/list";
    }

    @GetMapping("/member/{id}/edit")
    public String memberEdit(@PathVariable("id") int id, Model model){
        // edit.html 출력
        Member findedMember = memberRepository.findById(id);
        model.addAttribute("findMember",findedMember);
        return "member/edit";
    }

    @PostMapping("/member/edit")
    public String memberEdit(@ModelAttribute Member member){
        int result = memberRepository.update(member);
        System.out.println("MemberController.memberEdit = " + result);
        return "redirect:../member/list";
    }


    @GetMapping("/member/{id}/delete")
    public String memberDelete(@PathVariable("id") int id, Model model){
        // edit.html 출력
        Member findedMember = memberRepository.findById(id);
        model.addAttribute("findMember",findedMember);
        return "member/delete";
    }


    @PostMapping("/member/delete")
    public String memberDelete(@ModelAttribute Member member){
        int result = memberRepository.delete(member);
        System.out.println("MemberController.memberDelete = " + result);
        return "redirect:../member/list";
    }
}
