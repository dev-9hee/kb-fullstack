package ch12.sec08;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

// TimeZone : 타임존 지정하기
public class LosAngelesExample {
    public static void main(String[] args) {
        // 이 타임존은 미국 서부 시간대(Pacific Time)를 나타냄
        TimeZone timeZone = TimeZone.getTimeZone("Amerial/Los_Angeles");
        Calendar now = Calendar.getInstance(timeZone);

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if (amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour      = now.get(Calendar.HOUR);
        int minute    = now.get(Calendar.MINUTE);
        int second    = now.get(Calendar.SECOND);

        System.out.print(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }
}
