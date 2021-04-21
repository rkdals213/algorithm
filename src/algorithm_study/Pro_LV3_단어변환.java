package algorithm_study;

import java.util.LinkedList;
import java.util.Queue;

public class Pro_LV3_단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin, target, words));
    }

    static public int solution(String begin, String target, String[] words) {
        if (!isIn(target, words)) return 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, begin));
        boolean[] visited = new boolean[words.length];

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < begin.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    char[] charArray = p.word.toCharArray();
                    charArray[i] = (char) ((charArray[i] + j) % 26 + 97);
                    String next = arrayToString(charArray);
                    if (isEq(next, target) && isIn(next, words)) return p.count + 1;
                    if (isIn(next, words) && !visited[getCount(next, words)]) {
                        q.add(new Point(p.count + 1, next));
                        visited[getCount(next, words)] = true;
                    }
                }
            }
        }
        return 0;
    }

    static String arrayToString(char[] word) {
        StringBuilder result = new StringBuilder();
        for (char c : word) {
            result.append(c);
        }
        return result.toString();
    }

    static boolean isIn(String next, String[] words) {
        for (String word : words) {
            if (next.equals(word)) return true;
        }
        return false;
    }

    static int getCount(String next, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (next.equals(words[i])) return i;
        }
        return 0;
    }

    static boolean isEq(String next, String target) {
        return next.equals(target);
    }

    static class Point {
        int count;
        String word;

        public Point(int count, String word) {
            this.count = count;
            this.word = word;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "count=" + count +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
}
