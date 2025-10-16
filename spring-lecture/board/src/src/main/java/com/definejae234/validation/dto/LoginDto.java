package com.definejae234.validation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor  // 생성자 자동 생성
@AllArgsConstructor // NoArgs 하나만 있으면 안됨
public class LoginDto {
    @NotBlank(message = "사용자 아이디는 필수 입력 사항입니다.")
    private String userID;

    @NotBlank(message = "사용자 비밀번호는 필수 입력 사항입니다.")
    @Size(min = 2, max = 16, message = "비밀번호는 4글자 이상 16자 이하로 입력해주세요.")
    private String userPW;
}
