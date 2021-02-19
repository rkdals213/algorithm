package ElevenST_CodingTest;

import java.lang.reflect.Array;
import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        int[] a = {1, 2, 1};
        int[] b = {2, 1, 4, 4};
        int[] c = {5, 6, 7, 8, 8};
        int[] d = {5, 6, 6, 6, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 15};

        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));
        System.out.println(solution(d));
    }

    static int solution(int[] A) {
        int answer = 0;
        boolean[] v = new boolean[2000001];
        Queue<Integer> q = new LinkedList<>();

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (!v[A[i]]) v[A[i]] = true;
            else q.add(A[i]);
        }

        for (int i = 1; i < v.length; i++) {
            if (!v[i]) {
                int t = q.poll();
                answer += Math.abs(t - i);
                v[i] = true;
            }
            if (q.isEmpty()) break;
            if (answer > 1000000000) return -1;
        }
        return answer;
    }
}
