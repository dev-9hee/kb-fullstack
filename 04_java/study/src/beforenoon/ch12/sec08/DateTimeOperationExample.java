package beforenoon.ch12.sec08;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 날짜와 시간 조작
// java.time 패키지의 LocalDateTime 클래스가 제공하는 메소드를 통해 날짜와 시간을 조작 가능
public class DateTimeOperationExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // 현재 날짜와 시간 정보를 LocalDateTime 객체로 생성하는 것
        // 이 코드는 DateTimeFormatter 객체를 생성하여 특정 형식의 문자열로 날짜와 시간을 표현할 수 있도록 설정
        // "yyyy": 4자리 연도, "MM": 2자리 월, "dd": 2자리 일
        // "a": AM/PM 표시, "HH": 24시간 형식의 시, "mm": 분, "ss": 초
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println("현재 시간: " + now.format(dtf));

        LocalDateTime result1 = now.plusYears(1);
        System.out.println("1년 덧셈: " + result1.format(dtf));

        LocalDateTime result2 = now.minusMonths(2);
        System.out.println("2월 뺄셈: " + result2.format(dtf));

        LocalDateTime result3 = now.plusDays(7);
        System.out.println("7월 덧셈: " + result3.format(dtf));
    }
}
