package com.definejae234.hi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiApplication {
    // 생성을 하지 않았는데도 스프링 부트가 알아서 생성한는 것을 IoC를 한다. 외부에있는 컨테이너에 주입을 함.
    // 제어를 내가 하는게 아닌 spring에 해줌
    public static void main(String[] args) {
        SpringApplication.run(HiApplication.class, args);
    }

}
