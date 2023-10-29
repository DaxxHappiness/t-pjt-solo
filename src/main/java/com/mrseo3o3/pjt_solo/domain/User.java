package com.mrseo3o3.pjt_solo.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private Long uid;
    private String email;
    private String password;
    private String name;
    private String phone;
//    private String subscription;
}
