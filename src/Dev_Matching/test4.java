package Dev_Matching;

import java.util.*;

public class test4 {
    public static void main(String[] args) {

        String[] votes1 = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN"
                , "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
        String[] votes2 = {"AAD", "AAA", "AAC", "AAB"};
        System.out.println(solution(votes1, 2));
        System.out.println(solution(votes2, 4));
    }

    static String solution(String[] votes, int k) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            if(map.containsKey(votes[i])) map.replace(votes[i], map.get(votes[i])+1);
            else map.put(votes[i], 1);
        }

        PriorityQueue<Point> q = new PriorityQueue<>();

        for (String key : map.keySet()) {
            int value = map.get(key);
            Point p = new Point(key, value);
            q.add(p);
        }

        Deque<Point> dq = new ArrayDeque<>();

        int max = 0;

        while (!q.isEmpty()){
            Point t = q.poll();
            if(k > 0){
                max += t.vote;
                k--;
            }
            dq.addLast(t);
        }

        int cnt = 0;
        String last = "";
        while(true){

            Point t = dq.removeLast();
            if(cnt + t.vote < max) {
                last = t.car;
                cnt += t.vote;
            }
            else break;
        }

        return last;
    }

    static class Point implements Comparable<Point>{
        String car;
        int vote;

        public Point(String car, int vote) {
            this.car = car;
            this.vote = vote;
        }

        @Override
        public int compareTo(Point o) {
            if(this.vote == o.vote){
                return this.car.compareTo(o.car);
            }else return -Integer.compare(this.vote, o.vote);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "car='" + car + '\'' +
                    ", vote=" + vote +
                    '}';
        }
    }
}
