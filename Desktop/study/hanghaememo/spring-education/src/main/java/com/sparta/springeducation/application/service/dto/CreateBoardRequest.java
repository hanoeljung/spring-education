package com.sparta.springeducation.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {
    private  String title;
    private String writer;
    private String password;
    private String content;


    public CreateBoardRequest(String title, String writer, String password, String content) {
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;
    }
}
