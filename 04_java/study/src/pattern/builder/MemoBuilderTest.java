package pattern.builder;

import java.util.Date;

public class MemoBuilderTest {
    public static void main(String[] args) {
        Memo memo = new Memo.Builder()
                .id(10L)
                .title("제목")
                .content("메모 내용")
                .writer("홍길동")
                .date(new Date())
                .build();

        System.out.println(memo);
    }
}
