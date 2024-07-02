package codingtest.week1.exam05;

import java.util.Arrays;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 강사님 풀이, 정렬 사용
public class Solution5_1 {
    public boolean solution(String[] phone_book) {
        // ✅ phone_book 정렬한다.
        Arrays.sort(phone_book);

        // ✅ i를 0 ~ phone_book.length - 2까지 순회한다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            //✅ phone_book[i+1]이 phone_book[i]로 시작한다면 false 를 반환한다.
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // ✅ 접두어를 찾지 못했다면 true 를 반환한다.
        return true;
    }

    public static void main(String[] args) {
        Solution5_1 solution5_1 = new Solution5_1();
        boolean result = solution5_1.solution(new String[]{"123","456","789"});
        System.out.println(result);
    }
}
