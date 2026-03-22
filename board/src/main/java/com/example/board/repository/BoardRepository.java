package com.example.board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.board.entity.BoardEntity;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Integer> {
    // 쿼리 메서드 
    List<BoardEntity> findAllByOrderByBoardIdxDesc();
}

