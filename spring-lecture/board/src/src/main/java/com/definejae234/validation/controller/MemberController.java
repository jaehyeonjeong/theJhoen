package com.definejae234.validation.controller;

import com.definejae234.validation.dto.LoginDto;
import com.definejae234.validation.dto.MemberDto;
import com.definejae234.validation.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")  // get, post 둘다 받을 수 있는 범용 앵커
public class MemberController {
    private final MemberRepository memberRepository;

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
                             Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(memberDto);
            model.addAttribute("msg", true);
            return "member/add";
        }
        System.out.println(memberDto);
        // 이렇게 redirect를 하는 이유는 브라우저에 표시되는 url을 /member/list로 만들기위해
        return "redirect:../member/list";
    }

    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id) {
        return "member/detail";
    }

    @GetMapping("/login")
    public String login(Model model) {
        // 검증을 위한 Dto 생성후 Attribute 추가
        model.addAttribute("loginDto", new LoginDto());
        return "member/login";
    }

    @PostMapping("/login")
//    @ResponseBody // 자꾸 까먹네... ResponseBody 하면 텍스트로만 나오니까
    // 브라우저를 타도 member/login이라는 텍스트만 나옴
    public String loginProcess(@Valid @ModelAttribute LoginDto loginDto,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println(loginDto);
            model.addAttribute("msg", true);
            // 브라우저에 로그인 페이지로 전환
            return "member/login";
        }
        MemberDto loginMember = memberRepository.findById(loginDto);

        if (loginMember == null) {
            // 글로벌 에러 globalErrors
            bindingResult.reject(   // 거부
                    "error.user",
                    "아이디 및 패스워드가 맞지 않습니다.");
            return "member/login";
        }

        System.out.println(loginDto);
        return loginMember.toString();
    }
}
