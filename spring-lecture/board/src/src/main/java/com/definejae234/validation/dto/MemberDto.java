package com.definejae234.validation.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor  // 생성자 자동 생성
@AllArgsConstructor // NoArgs 하나만 있으면 안됨
public class MemberDto {
    // 시퀀스 처리는 신경 ㄴㄴ
    private int id;
    // 프론트에서 검증하는 validation 중 1개 : @NotBlank

    @NotBlank(message = "사용자 아이디는 필수 입력 사항입니다.")
    private String userID;

    @NotBlank(message = "사용자 비밀번호는 필수 입력 사항입니다.")
    @Size(min = 4, max = 16, message = "비밀번호는 4글자 이상 16자 이하로 입력해주세요.")
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\\\"'<>,.?/]).+$",
            message="비밀번호는 영문 대문자/소문자/특수문자/숫자를 모두 포함해야 합니다.")
    private String userPW;

    @NotBlank(message = "이름은 필수 입력 사항입니다.")
    private String userName;

    @Email(message = "이메일 형식에 맞게 입력해주세요.")
    @NotBlank(message = "이메일은 필수 입력 사항입니다.")
    private String userEmail;
}
