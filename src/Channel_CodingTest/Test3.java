package Channel_CodingTest;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(5));
        System.out.println(solution(2));
        System.out.println(solution(3));
        long start = System.currentTimeMillis();
        System.out.println(solution(100));
        long end = System.currentTimeMillis();
        long timeMs = end - start;
        System.out.println(timeMs);
    }

    static public long solution(int n) {
        result = 0;
        target = n;
        DFS(new ArrayList<>(), 0, 0);
        return result;
    }

    static long result = 0;
    static int target = 0;

    static void DFS(List<Integer> list, int sum, int now) {
        if (sum == target && list.size() >= 2) {
            long mul = list.stream().mapToInt(i -> i).reduce(1, (a,b) -> a * b);
            result = Long.max(result, mul);
            return;
        }

        for (int i = now; i < sosu.length; i++) {
            if (sum + sosu[i] <= target) {
                List<Integer> nList = new ArrayList<>(list);
                nList.add(sosu[i]);
                DFS(nList, sum + sosu[i], i);
            }
        }
    }

    static int[] sosu = {1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};
}
