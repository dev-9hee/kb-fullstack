package ch12.sec08;

import java.util.Calendar;


// Calendar 클래스 : 달력을 표현하는 추상 클래스
// getInstance() 메소드로 컴퓨터에 설정된 시간대 기준으로 Calendar 하위 객체를 얻을 수 있음
public class CalendarExample {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);

        int week = now.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch (week) {
            case Calendar.MONDAY:       strWeek = "월"; break;
            case Calendar.TUESDAY:      strWeek = "화"; break;
            case Calendar.WEDNESDAY:    strWeek = "수"; break;
            case Calendar.THURSDAY:     strWeek = "목"; break;
            case Calendar.FRIDAY:       strWeek = "금"; break;
            case Calendar.SATURDAY:     strWeek = "토"; break;
            default:                    strWeek = "일";
        }

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

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.println(day + "일 ");
        System.out.print(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }
}
