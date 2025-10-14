package com.definejae234.ajax.controller;

import com.definejae234.ajax.dto.BookDto;
import com.definejae234.ajax.dto.JoinDto;
import com.definejae234.ajax.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping({"/", "/home", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @PostMapping("/ajax")
    @ResponseBody
    public String ajaxPost(@RequestParam(value = "userID") String userID,
                           @RequestParam(value = "userPW") String userPW) {
        System.out.println("userID=" + userID + " userPW=" + userPW);
        return "userID===" + userID + ",userPW===" + userPW;
    }

    @PostMapping("/ajax02")
    @ResponseBody
    // 요청에 대한 응답이 기본이기 때문에 요청은 MAP으로 한다.
    public String ajaxPost02(@RequestBody Map<String, String> receiveMap) {


        String userID = receiveMap.get("userID");
        String userPW = receiveMap.get("userPW");
        int age = Integer.parseInt(receiveMap.get("age"));

        System.out.println("userID=" + userID +
                ", userPW=" + userPW +
                ", age=" + age);
        return "basic output";
    }

    @PostMapping("/ajax03")
    @ResponseBody
    // join할 수 있는 객체를 만들어두면 데이터 관리에 용이하다.
    public String ajaxPost03(@RequestBody JoinDto joinDto) {

        System.out.println(joinDto.getUserID() + ", " +
                joinDto.getUserPW() + ", " +
                joinDto.getAge());
        return "응답 response";
    }

    @PostMapping("/ajax04")
    @ResponseBody
    // join할 수 있는 객체를 만들어두면 데이터 관리에 용이하다.
    public Map<String, Boolean> ajaxPost04(@RequestBody JoinDto joinDto) {

        System.out.println(joinDto.getUserID() + ", " +
                joinDto.getUserPW() + ", " +
                joinDto.getAge());
        Map<String, Boolean> responseMap = new HashMap<>();
        // 변수명에 따라 값을 출력
        // db에 입력하고 결과를 받는 형식으로 된다.
        responseMap.put("isJoin", true);
        return responseMap;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody   // 단순 결과를 출력하기 위한 응답
    public Map<String, Boolean> loginProcess(@RequestBody LoginDto loginDto) {

        Map<String, Boolean> responseMap = new HashMap<>();
        System.out.println(loginDto.getUserID() + " " +  loginDto.getUserPW());
        if (loginDto.getUserID().equals("definejae234") &&
                loginDto.getUserPW().equals("1234")) {
            responseMap.put("isLogin", true);
        } else {
            responseMap.put("isLogin", false);
        }
        return responseMap;
    }


    @GetMapping("/books")
    public String loginProcess() {
        return "kakaobook";
    }
}
