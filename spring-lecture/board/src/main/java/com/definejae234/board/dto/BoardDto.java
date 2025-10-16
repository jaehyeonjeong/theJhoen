package com.definejae234.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int id;

    @NotBlank(message = "도서의 제목을 입력해주세요")
    private String title;
    @NotBlank(message = "도서의 내용을 입력해주세요")
    private String content;
    @NotBlank(message = "도서의 저자를 입력해주세요")
    private String writer;
    private LocalDateTime regDate;
    private int hit;
    @NotBlank(message = "도서의 비밀번호를 입력해주세요")
    @Size(min = 4, max = 16, message = "비밀번호는 4글자 이상 16자 이하로 입력해주세요.")
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\\\"'<>,.?/]).+$",
            message="비밀번호는 영문 대문자/소문자/특수문자/숫자를 모두 포함해야 합니다.")
    private String password;
}
