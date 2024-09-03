package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.Board;
import org.example.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j
@CrossOrigin(origins = "*")
@RequestMapping("/rest/board")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    // 문제 1. 게시판 목록 기능 구현하기, !!!!!
    @GetMapping("/list")
    public ResponseEntity<List<Board>> listPage() {
        // 여기 부분에 코드를 완성하여, 게시판 목록 기능을 완성시켜 주세요
        List<Board> boardList = boardService.getList();
        return ResponseEntity.ok(boardList);
    }

    // 문제 2. 게시글 작성 기능 구현하기
    @PostMapping("/create")
    public ResponseEntity<Board> create(
            @RequestBody Board board // 프론트엔드에서 Request 의 Body 를 통해서 전달됨
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 작성 기능을 완성시켜 주세요
        boardService.create(board);
        return ResponseEntity.ok(board);
    }

    // 문제 3. 게시글 내용 보기 기능 구현하기, !!!!!
    @GetMapping("/detail/{id}")
    public ResponseEntity<Board> detailPage(
            @PathVariable Long id
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 내용 보기 기능을 완성시켜 주세요
        Board board = boardService.detail(id);
        return ResponseEntity.ok(board);
    }

    // 문제 4. 게시글 삭제 기능 구현하기
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id) {
        // 여기 부분에 코드를 완성하여, 게시글 삭제 기능을 완성시켜 주세요
        boardService.delete(id);
        return ResponseEntity.ok("삭제 성공");
    }

    // 문제 5. 게시글 수정 기능 구현하기
    @PostMapping("/update")
    public ResponseEntity<Board> update(
            @RequestBody Board updateBoard
    ) {
        // 여기 부분에 코드를 완성하여, 게시글 수정 기능을 완성시켜 주세요
        boardService.update(updateBoard);
        return ResponseEntity.ok(updateBoard);
    }
}
