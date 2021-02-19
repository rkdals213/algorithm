package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_9205_S1_맥주마시면서걸어가기 {
    static boolean[][] visited;
    static boolean result = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(temp.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < TC; i++) {
            result = false;
            List<Point> list = new ArrayList<>();
            temp = new StringTokenizer(br.readLine());
            int storenum = Integer.parseInt(temp.nextToken());
            temp = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(temp.nextToken()),
                    Integer.parseInt(temp.nextToken()), 0));
            for (int j = 0; j < storenum; j++) {
                temp = new StringTokenizer(br.readLine());
                list.add(new Point(Integer.parseInt(temp.nextToken()),
                        Integer.parseInt(temp.nextToken()), 0));
            }
            temp = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(temp.nextToken()),
                    Integer.parseInt(temp.nextToken()), 0));
            //DFS(list.get(0), list, new boolean[storenum+2]);
            Queue<Point> queue = new LinkedList<>();
            queue.add(list.get(0));
            boolean visited[] = new boolean[storenum + 2];
            while (!queue.isEmpty()) {
                Point t = queue.poll();
                if (t.i == list.get(list.size() - 1).i && t.j == list.get(list.size() - 1).j) {
                    result = true;
                    break;
                }
                for (int j = 1; j < list.size(); j++) {
                    if (!visited[j]) {
                        int length = Math.abs(list.get(j).i - t.i) + Math.abs(list.get(j).j - t.j);
                        if (length <= 1000) {
                            queue.add(list.get(j));
                            visited[j] = true;
                        }
                    }
                }
            }


            if (result) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }
        System.out.println(sb);
    }

    static void DFS(Point p, List<Point> list, boolean[] visited) {
        boolean f = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                f = false;
                break;
            }
        }
        if (f) {
            result = false;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (!visited[i]) {
                    if (Math.abs(list.get(i).i - p.i) + Math.abs(list.get(i).j - p.j) <= 1000) {
                        if (p.i == list.get(list.size() - 1).i && p.j == list.get(list.size() - 1).j) {
                            result = true;
                            return;
                        }
                        visited[i] = true;
                        DFS(list.get(i), list, visited);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    static class Point {
        int i;
        int j;
        int count;

        public Point(int i, int j, int count) {
            super();
            this.i = i;
            this.j = j;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point [i=" + i + ", j=" + j + "]";
        }
    }

}
