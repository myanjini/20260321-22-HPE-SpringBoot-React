package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private BoardService boardService;
    
    // 목록 조회
    @GetMapping("/board")
    public List<BoardDto> openBoardList() throws Exception {
        return boardService.selectBoardList();
    }
    
    // 글 저장 요청을 처리하는 메서드 
    @PostMapping("/board")
    public void insertBoard(@RequestBody BoardDto boardDto) throws Exception {
        boardService.insertBoard(boardDto);
    }
    
    // 상세 조회 요청을 처리하는 메서드
    @GetMapping("/board/{boardIdx}")
    public BoardDto openboardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        return boardService.selectBoardDetail(boardIdx);
    }
}
