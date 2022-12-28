package com.sparta.springeducation.application.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateBoardRequest {
    private String title;
    private String writer;
    private String content;
    private String password;
}
