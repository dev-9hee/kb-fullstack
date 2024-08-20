package org.example.repository.book.mybatis;

import lombok.RequiredArgsConstructor;
import org.example.domain.BookMybatis;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final BookMapper bookMapper;

    public List<BookMybatis> findAll() {
        return bookMapper.findAll();
    }

    public BookMybatis findById(Long id) {
        return bookMapper.findById(id);
    }

    public int save(BookMybatis newBook) {
        return bookMapper.save(newBook);
    }

    public int delete(Long id) {
        return bookMapper.delete(id);
    }
}
