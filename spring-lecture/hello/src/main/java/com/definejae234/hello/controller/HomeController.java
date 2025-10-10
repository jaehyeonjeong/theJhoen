package com.definejae234.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// 자바 리플렉션을 이용해서 응답 코드를 반환할 수 있음.
@Controller
public class HomeController {

    // 서버 요청 (get 요청) -> hello를 요청
    @GetMapping("/hello")
    // 응답할 리턴 요소
//    @ResponseBody
    public String hello(){
//        return "<h1>Hello World!</h1><h2>Hello World!</h2>";
          return "hello"; // hello를 입력하면 template 폴더에 있는 hello.html을 찾음 -> templates/+hello+.html
    }

    @GetMapping({"/","/home","/index"})
    public String home() {
        return "home";
    }

    @GetMapping("/request")
    public String request() {
        return "request";
    }

    @PostMapping ("/result")
//    @ResponseBody
    // binding
    // Map<String, String>
    public String result(@RequestParam(name = "userID", required = false, defaultValue = "") String userID02,
                         @RequestParam(name = "userPW", required = false, defaultValue = "") String userPW,
                         @RequestParam(name = "userName", required = false, defaultValue = "") String userName,
                         Model model) {
        // 위에 있는 파라미터의 name은 생략해도됨. 단 인풋 타입 하나만 있는 경우에서 생략가능
        // 요청된 값을 처리
        System.out.println("userID === " + userID02);
        System.out.println("userPW === " + userPW);

//        Map<String, String> map = new HashMap<>();

        // String이 아닌 객체를 응답하면 json으로 변환되어서 결과를 return 한다.
        if(userID02.equals("definejae234") && userPW.equals("1234")){
//            map.put("result", "success");
//            return map;
            // 매개변수에서 넘어간 값을 addAttribute로 전달
            model.addAttribute("userName",userName);
            // 모델은 서버에서 받은 데이터를 html로 내려 보냄
            return "login-ok";
        }
//        map.put("result", "fail");
//        return map;
        model.addAttribute("userName","실패");
        return "login-fail";
    }
}
