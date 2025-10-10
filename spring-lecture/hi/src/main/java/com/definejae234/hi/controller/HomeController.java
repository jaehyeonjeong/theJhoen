package com.definejae234.hi.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller; // 부모는 Component
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// di : dependency injection(의존성 주입) = IoC (Inversion of Control)
// @Controller 라는 annotation을 달면 scan을 해서 spring 컨테이너에 담아둔다.
// URL 맵핑
@Controller
//@Component
public class HomeController {
    // Component Scan : 브라우저한테 처리를 맡김
    // thymeleaf를 하면 resource/templates 폴더안의 html 파일을 찾는다.
    @GetMapping("/home") // trigger -> 엔터 치는 방식 또는 form
//    @ResponseBody
    public String home() {
        return "home";
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String gugudan(@RequestParam(value = "dan", required = true, defaultValue = "2") String dan) {
        System.out.println("dan : " + dan);
        int myDan = Integer.parseInt(dan);

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>" + myDan + "단을 출력합니다. </h1>");
        sb.append("<ul>");
        for (int i = 0; i < 9; i++) {
            sb.append("<li>" + dan + " x + " + i + " = " + myDan * i + "</li>");
        }
        sb.append("</ul>");
        return sb.toString();
    }

    @GetMapping("/gugudan02")
//    @ResponseBody
    public String gugudan02(@RequestParam(value = "dan", required = true, defaultValue = "2") String paramDan,
                            Model model
    ) {
        int dan;
        try {
            dan = Integer.parseInt(paramDan);

        } catch (NumberFormatException e) {
            dan = 0;
        }

        model.addAttribute("dan", dan);
        return "gugudan02";
    }

    @GetMapping("/send")
//    @ResponseBody
    public String send() {
        return "send";
    }

    @GetMapping("/form-result")
    @ResponseBody
    public String formResult(@RequestParam(value = "userID", required = false) String userID,
                             @RequestParam(value = "userPW", required = false) String userPW,
                             // 이름이 같은건 리스트로 넘어온다.
                             @RequestParam(value = "favorite", required = false) List<String> favorite,
                             @RequestParam(value = "gender", required = false) String gender,
                             @RequestParam(value = "country", required = false) String country,
                             Model model) {
        System.out.println("userID : " + userID);
        System.out.println("userPW : " + userPW);
        System.out.println("favorite : " + String.join(",", favorite));
        System.out.println("gender : " + gender);
        System.out.println("country : " + country);

        model.addAttribute("userID", userID);
        model.addAttribute("userPW", userPW);
        model.addAttribute("gender", gender);
        model.addAttribute("favorite", favorite);
        model.addAttribute("country", country);
        return "form-result";
    }

    @GetMapping("/tjoeun")
    public String tjoeun() {
        return "tjoeun";
    }

    @GetMapping("/form-tjoeun-result")
//    @ResponseBody
    public String tjoeunResult(
            @RequestParam(value = "campus", required = false, defaultValue = "ilsan") String campus,
            @RequestParam(value = "userName", required = false, defaultValue = "person") String userName,
            @RequestParam(value = "phone1", required = false, defaultValue = "012") String phone1,
            @RequestParam(value = "phone2", required = false, defaultValue = "2345") String phone2,
            @RequestParam(value = "phone3", required = false, defaultValue = "6789") String phone3,
            @RequestParam(value = "userFavorite", required = false) String userFavorite,
            @RequestParam(value = "message", required = false, defaultValue = "basic message") String message,
            @RequestParam(value = "privacy", required = false, defaultValue = "off") String privacy,
            Model model
    ) {
        String phoneNumber = String.join("-", phone1, phone2, phone3);
        System.out.println("campus : " + campus);
        System.out.println("userName : " + userName);
        System.out.println("userPhone : " + phoneNumber);
        System.out.println("userFavorite : " + userFavorite);
        System.out.println("message : " + message);
        System.out.println("privacy : " + privacy);

        model.addAttribute("campus", campus);
        model.addAttribute("userName", userName);
        model.addAttribute("userPhone", phoneNumber);
        model.addAttribute("userFavorite", userFavorite);
        model.addAttribute("message", message);
//        model.addAttribute("privacy", privacy);

        // 아래 조건문은 @ResponseBody인 경우에만 출력이되는 것 같음
//        if (!privacy.equals("on")) {
//            return "<script>alert('개인정보 동의하셔야 합니다.');history.back();</script>";
//        }

        return "form-tjoeun-result";
    }
}
