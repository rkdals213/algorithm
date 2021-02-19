package ElevenST_CodingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        String[] s = {"abc", "bca", "dbe"};
        String[] s1 = {"zzzz", "ferz", "zdsr", "fgtd"};
        String[] s2 = {"gr", "sd", "rg"};

        System.out.println(Arrays.toString(solution(s)));
        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
    }

    static int[] solution(String[] S) {
        int[] answer = new int[3];
        boolean f = false;

        for (int i = 0; i < S[0].length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < S.length; j++) {
                if (!map.containsKey(S[j].charAt(i))) {
                    map.put(S[j].charAt(i), j);
                } else {
                    answer[0] = map.get(S[j].charAt(i));
                    answer[1] = j;
                    answer[2] = i;
                    f = true;
                }
            }
        }
        if (f) return answer;
        int[] no = {};
        return no;
    }
}
