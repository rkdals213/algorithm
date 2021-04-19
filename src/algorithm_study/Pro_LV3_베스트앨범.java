package algorithm_study;

import java.util.*;

public class Pro_LV3_베스트앨범 {
    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        System.out.println(solution(genres, plays));

        String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
        int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
        System.out.println(solution(genres, plays));
    }

    static public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        Map<String, PriorityQueue<Point>> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (!map1.containsKey(genres[i])) {
                PriorityQueue<Point> q = new PriorityQueue<>();
                q.add(new Point(plays[i], i));

                map1.put(genres[i], q);
                map2.put(genres[i], plays[i]);
            } else {
                map1.get(genres[i]).add(new Point(plays[i], i));
                map2.replace(genres[i], map2.get(genres[i]) + plays[i]);
            }
        }

        List<Point2> q = new ArrayList<>();

        map2.forEach((key, value) -> {
            q.add(new Point2(key, value));
        });

        q.sort((o1, o2) -> Integer.compare(o2.total, o1.total));

        for (Point2 p : q) {
            PriorityQueue<Point> a = map1.get(p.genre);
            for (int i = 0; i < 2; i++) {
                if (a.isEmpty()) continue;
                list.add(a.poll().num);
            }
        }

        return list;
    }

    static class Point implements Comparable<Point> {
        int plays;
        int num;

        public Point(int plays, int num) {
            this.plays = plays;
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            if (this.plays == o.plays) {
                return Integer.compare(this.num, o.num);
            } else return Integer.compare(o.plays, this.plays);
        }
    }

    static class Point2 {
        String genre;
        int total;

        public Point2(String genre, int total) {
            this.genre = genre;
            this.total = total;
        }
    }
}
