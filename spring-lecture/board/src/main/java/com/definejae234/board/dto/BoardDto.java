package com.definejae234.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private int hit;
    private String password;
}
