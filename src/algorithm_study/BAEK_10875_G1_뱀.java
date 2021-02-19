package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEK_10875_G1_뱀 {
    static int N;
    private static int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        long startx = 0;
        long starty = 0;

        temp = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(temp.nextToken());
        List<Point> list = new ArrayList<>();
        int dir = 0;
        int count = 0;
        long endx = 0;
        long endy = 0;
        outer:
        for (int i = 0; i < T; i++) {
            endx = startx;
            endy = starty;
            temp = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(temp.nextToken());
            String d = temp.nextToken();

            for (int j = 0; j < time; j++) {
                endx += dirs[dir][0];
                endy += dirs[dir][1];
                count++;
                if (!isIn(endx, endy)) {
                    System.out.println(count);
                    return;
                }
            }
            for (int j2 = 0; j2 < list.size(); j2++) {
                long listsx = Math.min(list.get(j2).startx, list.get(j2).endx);
                long listsy = Math.min(list.get(j2).starty, list.get(j2).endy);
                long listex = Math.max(list.get(j2).startx, list.get(j2).endx);
                long listey = Math.max(list.get(j2).starty, list.get(j2).endy);
                if (startx < endx) {
                    if (starty < endy) {

                    }
                } else {
                    if (starty < endy) {

                    }
                }
            }
            if (d.equals("L")) {
                dir++;
                if (dir == 4) dir = 0;
            } else {
                dir--;
                if (dir == -1) dir = 3;
            }
            list.add(new Point(startx, starty, endx, endy));
            startx = endx;
            starty = endy;
        }
        while (true) {
            endx += dirs[dir][0];
            endy += dirs[dir][1];
            count++;
            if (!isIn(endx, endy)) {
                System.out.println(count);
                return;
            }
            for (int j2 = 0; j2 < list.size(); j2++) {
                long listsx = list.get(j2).startx;
                long listsy = list.get(j2).starty;
                long listex = list.get(j2).endx;
                long listey = list.get(j2).endy;
                if (listsx > listex) {
                    if (listsy > listey) {
                        if ((endx >= listex && endx <= listsx) && (endy >= listey && endy <= listsy)) {
                            System.out.println(count);
                            return;
                        }
                    } else {
                        if ((endx >= listex && endx <= listsx) && (endy <= listey && endy >= listsy)) {
                            System.out.println(count);
                            return;
                        }
                    }
                } else {
                    if (listsy > listey) {
                        if ((endx <= listex && endx >= listsx) && (endy >= listey && endy <= listsy)) {
                            System.out.println(count);
                            return;
                        }
                    } else {
                        if ((endx <= listex && endx >= listsx) && (endy <= listey && endy >= listsy)) {
                            System.out.println(count);
                            return;
                        }
                    }
                }
            }
        }

    }

    private static boolean isIn(long i, long j) {
        return i >= -N && j >= -N && i <= N && j <= N;
    }

    static class Point {
        long startx, starty, endx, endy;

        public Point(long startx2, long starty2, long endx2, long endy2) {
            super();
            this.startx = startx2;
            this.starty = starty2;
            this.endx = endx2;
            this.endy = endy2;
        }

        @Override
        public String toString() {
            return "Point [startx=" + startx + ", starty=" + starty + ", endx=" + endx + ", endy=" + endy + "]";
        }

    }
}
