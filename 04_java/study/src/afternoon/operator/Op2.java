package afternoon.operator;

public class Op2 {
    public static void main(String[] args) {
        // 문자열 비교
//        String str1 = "abc";
//        String str2 = "def";
//
//        boolean result1 = str1.equals("def"); // .equals(비교할 문자열); => 문자열 함수, 숫자는 비교 안됨
//        boolean result2 = str1.equals("def");
//        boolean result3 = !str1.equals(str2); // false -> true
//
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);

        // 문자 비교의 특이점
        System.out.println("abc" == "abc");
        System.out.println("abc" == "def");
        System.out.println("abc" == new String("abc"));

        int score = 90;
        boolean result = score >= 80 && score <= 100;
        System.out.println(result);
    }
}
