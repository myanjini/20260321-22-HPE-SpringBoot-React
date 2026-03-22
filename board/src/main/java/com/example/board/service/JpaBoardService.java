package com.example.board.service;

import java.util.List;

import com.example.board.entity.BoardEntity;

public interface JpaBoardService {
    List<BoardEntity> selectBoardList();
    BoardEntity selectBoardDetail(int boardIdx);
    void insertBoard(BoardEntity boardEntity) throws Exception;
    void updateBoard(BoardEntity boardEntity);
    void deleteBoard(int boardIdx);
}
