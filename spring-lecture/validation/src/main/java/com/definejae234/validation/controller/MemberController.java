package com.definejae234.validation.controller;

import com.definejae234.validation.dto.MemberDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")  // get, post 둘다 받을 수 있는 범용 앵커
public class MemberController {
    @GetMapping("/add")
    public String add(Model model) {
        // 처음에 비어있는 DTO를 먼저 보내주어야 함.
        model.addAttribute("memberDto", new MemberDto());
        return "member/add";
    }

    // 로그인 암호화 (단방향, 양방향) <=> 복호화
    @PostMapping("/add")
    // 검증하는 속성 앞에 Valid를 달아주어야 함.
    // 바인딩 리절트는 검증하는 객체 뒤에 달기
    public String addProcess(@Valid @ModelAttribute MemberDto memberDto,
                             BindingResult bindingResult,
                             Model model){
        if(bindingResult.hasErrors()){
            System.out.println(memberDto);
            model.addAttribute("msg", true);
            return "member/add";
        }
        System.out.println(memberDto);
        // 이렇게 redirect를 하는 이유는 브라우저에 표시되는 url을 /member/list로 만들기위해
        return "redirect:../member/list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id){
        return "member/detail";
    }
}
