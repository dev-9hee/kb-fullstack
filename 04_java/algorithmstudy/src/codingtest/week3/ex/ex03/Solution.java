package codingtest.week3.ex.ex03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 조합 사용
public class Solution {
    public int solution(String[][] relation) {
        List<Set<Integer>> candidates = new ArrayList<>();
        int colSize = relation[0].length;

        for(int size = 1; size<= colSize; size++){
            List<Set<Integer>> combinations = generateCombinations(colSize,size);
            for(Set<Integer> comb : combinations){
                if(checkUnique(comb, relation) && checkMin(comb,candidates)){
                    candidates.add(comb);
                }
            }
        }

        return candidates.size();
    }


    public List<Set<Integer>> generateCombinations(int colSize, int size) {
        // 조합한 값을 저장
        List<Set<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), colSize, size, ans); // 조합
        return ans;
    }

    // n : 컬럼 개수, k : 행 개수
    public void backtrack(int start, List<Integer> path, int n, int k, List<Set<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new HashSet<>(path)); // 중복이 있으면 안되니까 hashset 으로!
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(i + 1, path, n, k, ans);
            path.remove(path.size() - 1);
        }
    }


    public boolean checkUnique(Set<Integer> set, String[][] relation){
        Set<String> checkSet = new HashSet<>();
        for (int i=0; i<relation.length; i++){
            StringBuilder sb = new StringBuilder();

            for (int j : set) {
                sb.append(relation[i][j]).append(" ");
            }
            // hashset 에 추가를 성공하면 true 리턴
            if(!checkSet.add(sb.toString())) return false; // 유일성이 없어!
            checkSet.add(sb.toString());
        }
        return false;
    }

    public boolean checkMin(Set<Integer> set, List<Set<Integer>> candidates){
        for(Set<Integer> c : candidates){
            if(set.containsAll(c)) return false;
        }
        return true;
    }
}
