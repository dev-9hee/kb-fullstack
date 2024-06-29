package ch12.sec08;

import java.util.TimeZone;

public class PrintTimeZoneID {
    public static void main(String[] args) {
        // 이 코드는 Java 에서 사용할 수 있는 모든 타임존 ID 목록을 문자열 배열로 반환
        // TimeZone.getAvailableIDs() 메서드는 JVM(Java Virtual Machine)에서 지원하는 모든 타임존 ID 목록을 배열 형태로 반환
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String id : availableIDs) {
            System.out.println(id);
        }
    }
}
