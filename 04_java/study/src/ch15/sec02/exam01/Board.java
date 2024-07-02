package ch15.sec02.exam01;

// 모델 클래스, 순수하게 데이터만 저장하는 클래스
public class Board {
    private String subject;
    private String content;
    private String writer;

    // 생성자로 필드 값 초기화
    public Board(String subject, String content, String writer) {
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }

    // getter, setter 를 통해서 설정
    // lombok 을 사용하면 @AllArgsConstructor, @Getter, @Setter or @Data
    // @Data : Getter, Setter, ToString, Equals, ... 여러 개 담고 있음
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }
}
