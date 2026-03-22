package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.entity.BoardEntity;
import com.example.board.service.JpaBoardService;

@RestController
@RequestMapping("/api/jpa")
public class JpaBoardController {
    @Autowired
    private JpaBoardService boardService;
    
    // 목록 조회
    @GetMapping("/board")
    public List<BoardEntity> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }
    
    // 저장 처리
    @PostMapping("/board")
    public void insertBoard(@RequestBody BoardEntity boardEntity) throws Exception {
        boardService.insertBoard(boardEntity);
    }
    
    // 상세 조회
    @GetMapping("/board/{boardIdx}")
    public BoardEntity openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        return boardService.selectBoardDetail(boardIdx);
    }
    
    // 수정 처리
    @PutMapping("/board/{boardIdx}")
    public BoardEntity updateBoard(@PathVariable("boardIdx") int boardIdx, @RequestBody BoardEntity boardEntity) throws Exception {
        boardEntity.setBoardIdx(boardIdx);
        boardService.updateBoard(boardEntity);
        return boardEntity;
    }
    
    // 삭제 처리
    @DeleteMapping("/board/{boardIdx}")
    public void deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
    }
    
}
