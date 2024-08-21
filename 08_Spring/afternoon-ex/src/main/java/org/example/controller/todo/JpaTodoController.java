package org.example.controller.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Todo;
import org.example.repository.book.jpa.JpaTodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Transactional
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class JpaTodoController {

    private final JpaTodoRepository jpaTodoRepository;

    @GetMapping("")
    public ResponseEntity<List<Todo>> findAll() {
        log.info("모든 할일 목록 조회");
        List<Todo> todoList = jpaTodoRepository.findAll();
        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable("id") Long id) {
        log.info("id 값으로 할일 목록 조회");
        Todo findTodo = jpaTodoRepository.findById(id);

        if (findTodo == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 찾을 수 없음

        return ResponseEntity.ok(findTodo);
    }

    @PostMapping("/{todo}")
    public ResponseEntity<Todo> addTodo(@PathVariable("todo") String todo) {
        log.info("할일 추가");
        Todo newTodo = new Todo(null, todo, false);
        Todo addedTodo = jpaTodoRepository.addTodo(newTodo);

        if (addedTodo == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // 처리 중에 예기치 못한 오류가 발생

        return ResponseEntity.ok(addedTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> completedTodo(@PathVariable("id") Long id) {
        log.info("Todo 완료 여부 변경");
        Todo todo = jpaTodoRepository.findById(id);

        if (todo == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        if (todo.isDone() == false) {
            todo = jpaTodoRepository.markAsDone(id);
        } else {
            todo = jpaTodoRepository.markAsNotDone(id);
        }

        return ResponseEntity.ok(todo);
    }

    @PutMapping("/update/{id}/{todo}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @PathVariable("todo") String todo) {
        log.info("Todo 내용 변경");
        Todo editTodo = jpaTodoRepository.updateTodo(id, todo);

        if (editTodo == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        return ResponseEntity.ok(editTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable("id") Long id) {
        log.info("Todo 삭제");
        Todo deleteTodo = jpaTodoRepository.deleteTodo(id);

        if (deleteTodo == null) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        return ResponseEntity.ok(deleteTodo);
    }
}
