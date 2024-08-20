package org.example.controller.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.BookMybatis;
import org.example.repository.book.mybatis.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(value = "/book/mybatis")
public class MybatisBookController {

    private final BookRepository bookRepository;

    @GetMapping("/show")
    public ResponseEntity<List<BookMybatis>> findAll() {
        List<BookMybatis> bookList = bookRepository.findAll();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/show/{id}") // pathVariable
    public ResponseEntity<BookMybatis> findById(@PathVariable("id") Long id) {
        BookMybatis findBook = bookRepository.findById(id);

        if (findBook == null) return ResponseEntity.notFound().build();
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        return ResponseEntity.ok(findBook);
    }

    @PostMapping("/save")
    public ResponseEntity<BookMybatis> save(
            @RequestParam("title") String title,
            @RequestParam("author") String author
    ) {
        BookMybatis newBook = new BookMybatis(null, title, author);
        int affectedRows = bookRepository.save(newBook);

        if (affectedRows == 0) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @DeleteMapping(value = "/delete/{id}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        int affectedRows = bookRepository.delete(id);

        if (affectedRows > 0) return ResponseEntity.ok("게시글 삭제 성공");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시글 삭제 실패");
    }
}
