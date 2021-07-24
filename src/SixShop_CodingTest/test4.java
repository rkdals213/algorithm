package SixShop_CodingTest;

import java.util.*;

public class test4 {
    public static void main(String[] args) {
        int N = 3;
        int[] times = {4,2,2,5,3};
        System.out.println(solution(N, times));
    }

    static public List<Integer> solution(int N, int[] coffee_times) {
        List<Integer> result = new ArrayList<>();

        Point[] slot = new Point[N];
        int cnt = 0;
        int cnt2 = 0;
        do {
            if (cnt < coffee_times.length) {
                for (int i = 0; i < N; i++) {
                    if (slot[i] == null || slot[i].time == 0) {
                        if (cnt == coffee_times.length) break;
                        slot[i] = new Point(cnt + 1, coffee_times[cnt]);
                        cnt++;
                    }
                }
            }

            PriorityQueue<Integer> temp = new PriorityQueue<>();
            int time = Arrays.stream(slot).filter(Objects::nonNull).min(Comparator.comparingInt(o -> o.time)).get().time;
            for (int i = 0; i < N; i++) {
                if (slot[i] == null) continue;
                slot[i].time -= time;
                if (slot[i].time == 0) {
                    temp.add(slot[i].id);
                    cnt2++;
                    slot[i] = null;
                }
            }

            result.addAll(temp);
        } while (cnt2 != coffee_times.length);

        return result;
    }

    static class Point {
        int id;
        int time;

        public Point(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
