package beforenoon.ch12.sec05;

// StringBuilder 클래스
// 내부 버퍼에 문자열을 저장해두고 그 안에서 추가, 수정, 삭제 작업을 하도록 설계
public class StringBuilderExample {
    public static void main(String[] args) {
        // 메소드 체이닝 패턴
        String data = new StringBuilder()
                .append("DEF") // DEF
                .insert(0, "ABC") // 인덱스 0에 ABC.. ABCDEF
                .delete(3,4) // 인덱스 3부터 4전까지 삭제, ABCEF
                .toString(); // 완성된 문자열 리턴
        System.out.println(data);
    }
}
