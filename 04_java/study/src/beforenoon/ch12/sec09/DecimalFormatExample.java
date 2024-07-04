package beforenoon.ch12.sec09;

import java.text.DecimalFormat;

// DecimalFormat : 변환 패턴
public class DecimalFormatExample {
    public static void main(String[] args) {
        double num = 1234567.89;

        DecimalFormat df;

        // 정수 자리까지 표기
        df = new DecimalFormat("#,###");
        System.out.println(df.format(num));

        // 무조건 소수 첫째 짜리까지 표기
        df = new DecimalFormat("#,###.0");
        System.out.println(df.format(num));
    }
}
