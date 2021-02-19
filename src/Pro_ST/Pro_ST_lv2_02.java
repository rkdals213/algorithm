package Pro_ST;

import java.util.*;

public class Pro_ST_lv2_02 {
    public static void main(String[] args) {
//        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    static int result = 0;
    static Set<Integer> set = new HashSet<>();

    static int solution(String numbers) {

        for (int i = 0; i < (1 << numbers.length()); i++) {
            List<Character> subset = new ArrayList<>();
            for (int j = 0; j < numbers.length(); j++) {
                if ((i & 1 << j) > 0) { // 이러면 포함된 원소
                    subset.add(numbers.charAt(j));
                }
            }
            if (!subset.isEmpty()) perm(0, new char[subset.size()], new boolean[subset.size()], subset);
        }

        for (int a : set) {
            boolean f = true;
            for (int i = 2; i < a; i++) {
                if (a % i == 0) {
                    f = false;
                    break;
                }
            }
            if (f) result++;
        }

        return result;
    }

    static void perm(int cur, char[] result, boolean[] visited, List<Character> input) {
        if (cur == result.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
            }
            if (Integer.parseInt(sb.toString()) > 1) set.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = 0; i < result.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    result[cur] = input.get(i);
                    perm(cur + 1, result, visited, input);
                    visited[i] = false;
                }
            }
        }
    }
}
