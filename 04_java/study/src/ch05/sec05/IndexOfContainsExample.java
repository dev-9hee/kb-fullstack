package ch05.sec05;

// 문자열 (위치) 찾기 : indexOf(), 포함되어 있지 않으면 -1 리턴
// 포함 여부 결과만 알고 싶은 경우 : constains() 메소드 사용
public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location); // 3
        String subString = subject.substring(location); // 인덱스 3부터 끝까지
        System.out.println(subString); // 프로그래밍

        location = subject.indexOf("자바"); // 0
        if(location != -1) { // 포함되어 있으면
            System.out.println("자바와 관련된 책이군요.");
        } else {
            System.out.println("자바와 관련 없는 책이군요.");
        }

        boolean result = subject.contains("자바"); // "자바"가 포함되어 있으면 true
        if(result) { // result가 true일 경우
            System.out.println("자바와 관련된 책이군요.");
        } else {
            System.out.println("자바와 관련 없는 책이군요.");
        }
    }
}
