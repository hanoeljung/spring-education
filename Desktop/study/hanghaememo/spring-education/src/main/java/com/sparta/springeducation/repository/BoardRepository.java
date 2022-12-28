package com.sparta.springeducation.repository;

import com.sparta.springeducation.application.service.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByDateUpdatedDesc();
}
