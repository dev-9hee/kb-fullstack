package ch12.sec03.exam03;

public class ToStringExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("삼성전자", "안드로이드");

        String strObj = myPhone.toString();
        System.out.println(strObj);

        //System.out.println() 메서드는 자동으로 myPhone 객체의 toString() 메서드를 호출하여 결과를 출력
        System.out.println(myPhone);
    }
}
