package ch12.sec03.exam04;

// 레코드 선언 : 데이터 전달을 위한 DTO 작성 시 반복적으로 사용되는 코드를 줄이기 위해 도입
// 변수의 타입과 이름을 이용해서 private final 필드가 자동 생성
// 생성자 및 Getter 메소드가 자동 추가
// hashCode(), equals(), toString() 메서드 자동 추가
public record Member(String id, String name, int age) {
}
