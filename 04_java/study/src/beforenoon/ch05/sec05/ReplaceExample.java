package beforenoon.ch05.sec05;

// 문자열 대체 : replace()
public class ReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String 입니다.";
        String newStr = oldStr.replace("자바", "JAVA");

        System.out.println("oldStr = " + oldStr);
        System.out.println("newStr = " + newStr);
    }
}
