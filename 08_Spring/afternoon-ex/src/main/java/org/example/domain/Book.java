package org.example.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id // PK 라는걸 알려줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title") // 명시적으로 선언
    private String title;
    @Column(name = "author")
    private String author;

    // 빈 생성자와 모든 필드 생성자를 반드시 생성
    public Book() {
    }

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
