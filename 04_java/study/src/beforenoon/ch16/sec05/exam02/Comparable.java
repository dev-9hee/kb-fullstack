package beforenoon.ch16.sec05.exam02;

@FunctionalInterface
public interface Comparable {
    // 이 메서드는 두 개의 문자열을 비교하고 그 결과를 정수 값으로 반환
    int compare(String a, String b);
}
