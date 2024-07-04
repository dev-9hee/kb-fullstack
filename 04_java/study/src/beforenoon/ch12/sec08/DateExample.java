package beforenoon.ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.Date;

// Date 클래스 : 날짜를 표현하는 클래스로 객체 간에 날짜 정보를 주고받을 때 사용
// Data() 생성자는 컴퓬터의 현재 날짜를 읽어 Date 객체로 만듦
public class DateExample {
    public static void main(String[] args) {
        Date now = new Date();
        String strNow1 = now.toString(); // now 변수에 저장된 날짜와 시간 정보를 문자열로 변환하는 기능을 수행
        System.out.println(strNow1);

        // SimpleDateFormat 클래스를 사용하여 날짜 및 시간 형식을 정의
        // 여기서 정의한 형식은 "yyyy.MM.dd HH:mm:ss"로, 연도-월-일 시:분:초 형식
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); // 날짜를 이형식으로 출력
        String strNow2 = sdf.format(now); // sdf.format(now)를 통해 now 변수의 날짜와 시간 정보를 "yyyy.MM.dd HH:mm:ss" 형식의 문자열로 변환
        System.out.println(strNow2);
    }
}
