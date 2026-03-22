package com.example.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardEntity> selectBoardList() {
        return boardRepository.findAllByOrderByBoardIdxDesc();
    }

    @Override
    public BoardEntity selectBoardDetail(int boardIdx) {
        Optional<BoardEntity> optional = boardRepository.findById(boardIdx);
        if (optional.isPresent()) {
            BoardEntity board = optional.get();

            board.setHitCnt(board.getHitCnt() + 1);
            boardRepository.save(board);

            return board;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void insertBoard(BoardEntity boardEntity) throws Exception {
        boardEntity.setCreatedId("admin");
        boardRepository.save(boardEntity);
    }

    @Override
    public void updateBoard(BoardEntity boardEntity) {
        boardEntity.setUpdatorId("admin");
        boardRepository.save(boardEntity);
    }

    @Override
    public void deleteBoard(int boardIdx) {
        boardRepository.deleteById(boardIdx);
    }

}
