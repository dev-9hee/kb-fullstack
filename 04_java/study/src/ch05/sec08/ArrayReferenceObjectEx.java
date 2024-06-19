package ch05.sec08;

public class ArrayReferenceObjectEx {
    public static void main(String[] args) {
        String[] strArray = new String[3];
        strArray[0] = "Java";
        strArray[1] = "Java";
        strArray[2] = new String("Java");

        System.out.println( strArray[0] == strArray[1]); // true : 같은 객체 참조 / 내용이 같을 때 같은 곳 참조
        System.out.println( strArray[0] == strArray[2]); // false : 다른 객체 참조 / strArray[2]는 new로 새로 참조
        System.out.println( strArray[0].equals(strArray[2])); // 내용 비교, true (문자열 동일)
    }
}
