package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j
@RequestMapping("/rest/board")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardRestController {
    // @RequiredArgsConstructor 에 의해 의존성이 자동으로 주입 됩니다
    private final BoardService boardService;

    // 문제 1. 게시판 목록 기능 구현하기    
    @GetMapping("/list")
    public ResponseEntity<List<Board>> listPage() {
        List<Board> boardList = boardService.getList();
        return ResponseEntity.ok(boardList);
    }

    // 문제 2. 게시글 작성 기능 구현하기
    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Board newBoard) {
        boardService.create(newBoard);
        return ResponseEntity.ok("작성 추가");
    }

    // 문제 3. 게시글 내용 보기 기능 구현하기
    @GetMapping("/detail/{id}")
    public ResponseEntity<Board> detailPage(
            @PathVariable("id") Long id
    ) {
        Board board = boardService.detail(id);
        return ResponseEntity.ok(board);
    }

    // 문제 4. 게시글 삭제 기능 구현하기
    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        // 여기 부분에 코드를 완성하여, 게시글 삭제 기능을 완성시켜 주세요
        boardService.delete(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return ResponseEntity.ok("삭제 성공");
    }

    // 문제 5-2. 게시글 수정 기능 구현하기
    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Board updatedBoard) {
        boardService.update(updatedBoard);
        return ResponseEntity.ok("수정 성공");
    }
}
