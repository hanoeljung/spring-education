package com.sparta.springeducation.controller;

import com.sparta.springeducation.application.service.BoardService;
import com.sparta.springeducation.application.service.dto.BoardResponse;
import com.sparta.springeducation.application.service.dto.CreateBoardRequest;
import com.sparta.springeducation.application.service.dto.UpdateBoardRequest;
import com.sparta.springeducation.application.service.entity.Board;
import com.sparta.springeducation.repository.BoardRepository;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RestController // api 서버와 연관

public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    public BoardController(BoardService boardService,
                           BoardRepository boardRepository) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }
    @PostMapping("boards")// Create Boards => 게시물을 생성한다.
    public void createBoard(@RequestBody CreateBoardRequest createBoardRequest){
        boardService.createBoard(createBoardRequest);
    }

    @GetMapping("boards/{boardId}")
    public BoardResponse getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @GetMapping("boards")
    public List<BoardResponse> getBoardList() {
        return boardService.getBoardList();
    }

    @PutMapping("boards/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequest updateBoardRequest) {
        boardService.updatedBoard(boardId, updateBoardRequest);
    }

    @DeleteMapping("boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId, @RequestParam String password) {
        boardService.deleteBoard(boardId, password);
      }

      public List<BoardResponse> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        return null;

      }
}
