package com.definejae234.db.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Member {
    private Integer id;
    private String userID;
    private String userPW;
    private String userName;
    private String userEmail;
}
