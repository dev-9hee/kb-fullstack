package afternoon.nested.local.ex1.ex2;

import java.util.Scanner;

public class Library {
    // 멤버 변수
    Book[] books;
    int bookCount;
    static final int LIBRARY_SIZE = 4; // 최대 책 4권 보관 가능

    Scanner scanner = new Scanner(System.in);

    // 생성자
    public Library() {
        this.books = new Book[LIBRARY_SIZE];
        bookCount = 0;
    }

    // 메서드
    public void addBook() {
        System.out.print("책 제목을 입력 하세요 : ");
        String title = scanner.nextLine();
        System.out.print("책 저자를 입력 하세요 : ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);

        if (bookCount == LIBRARY_SIZE) {
            System.out.println("더 이상 책을 보관할 수 없습니다.");
        } else {
            books[bookCount++] = book;
            System.out.println("보관 된 책의 수는 : " + bookCount);
        }

    }
    public void showBooks() {
        System.out.println("=== 책 목록 출력 ===");
        System.out.println("*** 총 보관 책의 수는 : " + bookCount + " 입니다 ***");
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            System.out.println((i+1) + ". 제목 : " + book.getTitle() + " / " + "저자 : " + book.getAuthor());
        }
    }

    // Book 중첩 클래스 선언 및 사용
    static class Book {
        // 멤버 변수
        String title; // 책 제목
        String author; // 책 저자

        Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }
}
