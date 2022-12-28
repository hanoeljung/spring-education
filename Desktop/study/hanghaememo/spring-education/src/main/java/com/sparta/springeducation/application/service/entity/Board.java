package com.sparta.springeducation.application.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
// boardRepository.save(board)
@Entity // 고유해야되요, 어디서? 내 시스템에서. 내 시스템에서 1번 아이디를 가진 게시물은 유일해야합니다.
        // Entity는 id를 가져야만 한다.
public class Board extends Timestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id = 0L;
    // 제목, 작성자명, 비밀번호, 작성 내용
    private String title;
    private String writer;
    private String password;
    private String content;

    protected Board() {}

    public Board(String title, String writer, String password, String content) {
        this.title = title;
        this.writer = writer;
        this.password = password;
        this.content = content;
    }

    public void update(String title, String writer, String content) {
        // 제목, 작성자명, 작성 내용을 수정
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public boolean isvalidPassword(String inPutPassword){
        if (inPutPassword.equals(this.password)) return true;
        else return false;
    }
}
