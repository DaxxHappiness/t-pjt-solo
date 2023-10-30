package com.mrseo3o3.pjt_solo.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto {
    private Long uid;
    private String email;
    private String password;
    private String name;
    private String phone;
//    private String subscription;
}
