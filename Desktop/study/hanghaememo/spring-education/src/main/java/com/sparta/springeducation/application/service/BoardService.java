package com.sparta.springeducation.application.service;

import com.sparta.springeducation.application.service.dto.BoardResponse;
import com.sparta.springeducation.application.service.dto.CreateBoardRequest;
import com.sparta.springeducation.application.service.dto.UpdateBoardRequest;
import com.sparta.springeducation.application.service.entity.Board;
import com.sparta.springeducation.repository.BoardRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service // DB 또는 controller를 통해서 전달 받은 데이터를 가지고 DB나 entity + entitiy에 있는 행위(UPDATE)를 일을 시킴.
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board board = new Board(createBoardRequest.getTitle(), createBoardRequest.getWriter(), createBoardRequest.getPassword(), createBoardRequest.getContent());
        boardRepository.save(board);

    }

    public BoardResponse getBoard(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() ->  new IllegalArgumentException("게시물 없음"));
        return new BoardResponse(board);

    }
@Transactional
    public void updatedBoard(Long boardId, UpdateBoardRequest updateBoardRequest) {
        Board boardSaved = boardRepository.findById(boardId).orElseThrow(() ->  new IllegalArgumentException("게시물 없음"));
        // 수정을 요청할 때 수정할 데이터와 비밀번호를 같이 보내서 서버에서 비밀번호 일치 여부를 확인하여 업데이트 해라.


        if(boardSaved.isvalidPassword(updateBoardRequest.getPassword())) {
            boardSaved.update(updateBoardRequest.getTitle(), updateBoardRequest.getWriter(), updateBoardRequest.getContent());
            boardRepository.save(boardSaved);
        }
        else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }

    public void deleteBoard(Long boardId, String password) {
        Board board = boardRepository.findById(boardId).orElseThrow(() ->  new IllegalArgumentException("게시물 없음"));
        if(board.isvalidPassword(password)) {
            boardRepository.delete(board);
        } else {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
        }
    }

    public List<BoardResponse> getBoardList() {
        List<Board> boardList = boardRepository.findAllByOrderByDateUpdatedDesc();
        List<BoardResponse> boardResponseList = new ArrayList<>();
        for(Board board : boardList) {
            boardResponseList.add(new BoardResponse(board));
        }
        return boardResponseList;
    }
}

