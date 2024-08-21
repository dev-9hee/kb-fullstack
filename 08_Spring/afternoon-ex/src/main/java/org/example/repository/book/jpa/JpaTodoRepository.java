package org.example.repository.book.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional
public class JpaTodoRepository {

    private final EntityManager em; // 이 인터페이스를 통해 데이터베이스와 상호작용

    // 할일 목록 받아오기
    public List<Todo> findAll() {
        String jpql = "SELECT t FROM Todo t";
        return em.createQuery(jpql, Todo.class).getResultList(); // 투두 엔티티를 대상으로 모든 레코드를 선택하는 쿼리를 실행
    }

    // id로 할일 목록 조회
    public Todo findById(Long id) {
        return em.find(Todo.class, id); // 기본 키(primary key)를 기준으로 엔티티를 조회
    }

    // 할일 추가
    public Todo addTodo(Todo newTodo) {
        em.persist(newTodo); // newTodo 객체를 데이터베이스에 저장
        return newTodo;
    }

    // 완료 여부
    public Todo markAsDone(Long id) {
        Todo todo = em.find(Todo.class, id);

        if (todo != null) {
            todo.setDone(true);
        }

        return todo;
    }

    // 미완료 여부
    public Todo markAsNotDone(Long id) {
        Todo todo = em.find(Todo.class, id);

        if (todo != null) {
            todo.setDone(false);
        }

        return todo;
    }

    // 할일 내용 변경
    public Todo updateTodo(Long id, String newTodo) {
        Todo todo = em.find(Todo.class, id);

        if (todo != null) {
            todo.setTodo(newTodo);
        }

        return todo;
    }

    // 할일 삭제
    public Todo deleteTodo(Long id) {
        Todo todo = em.find(Todo.class, id);
        if ( todo != null) em.remove(todo);

        return todo;
    }
}
