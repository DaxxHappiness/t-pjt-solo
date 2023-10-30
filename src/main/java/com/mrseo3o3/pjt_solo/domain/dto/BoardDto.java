package com.mrseo3o3.pjt_solo.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDto {
    private Long bno;
    private String subject;
    private String content;
    private String author;
    private LocalDateTime reg_date;
    private Long views;
    private Long uid;

    public BoardDto(String subject, String content, String author) {
        this.subject = subject;
        this.content = content;
        this.author = author;
    }
}
