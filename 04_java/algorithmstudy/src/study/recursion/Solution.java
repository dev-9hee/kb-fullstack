package study.recursion;

public class Solution {
    public int solution(int a, int b, int n) {
        return calculateCola(a, b, n, 0);
    }

    // 빈병 초기 값 : n , 빈병 a개를 주면 b병을 받을 수 있음
    public int calculateCola(int a, int b, int n, int totalBottles) {
        if (n < a) return totalBottles;
        int newCola = (n / a) * b;
        int remainingBottles = (n % a) + newCola;

        return calculateCola(a, b, remainingBottles, totalBottles + newCola);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(3, 1, 20);
        System.out.println(result);
    }
}
