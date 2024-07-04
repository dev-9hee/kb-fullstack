package beforenoon.ch05.sec05;

// 문자열 잘라내기 : subString()
public class SubStringExample {
    public static void main(String[] args) {
        String ssn = "880815-1234567";

        String firstNum =  ssn.substring(0,6); // 0부터 인덱스 6 전까지
        System.out.println(firstNum);

        String secondNum = ssn.substring(7); // 7부터 끝까지
        System.out.println(secondNum);
    }
}
