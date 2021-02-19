package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEK_16235_G5_나무재테크 {
    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] map;
    static Deque<tree> list2 = new ArrayDeque<>();
    static ArrayList<tree> list = new ArrayList<>();
    static ArrayList<tree> list3 = new ArrayList<>();
    static ArrayList<tree> deadlist = new ArrayList<>();
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());
        A = new int[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(temp.nextToken());
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken()) - 1;
            int y = Integer.parseInt(temp.nextToken()) - 1;
            int age = Integer.parseInt(temp.nextToken());
            list.add(new tree(x, y, age));
        }
        list.sort(new Comparator<tree>() {

            @Override
            public int compare(tree o1, tree o2) {
                Integer a1 = o1.age;
                Integer a2 = o2.age;
                return a1.compareTo(a2);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            list2.add(list.get(i));
        }

        while (K > 0) {
            int season = 0;
            if (season == 0) {
                for (int i = 0; i < list2.size(); i++) {
                    tree treetemp = list2.poll();
                    int mapx = treetemp.x;
                    int mapy = treetemp.y;
                    int mapage = treetemp.age;
                    if (map[mapx][mapy] - mapage >= 0) {
                        map[mapx][mapy] -= mapage;
                        list2.add(new tree(mapx, mapy, mapage + 1));
                    } else {
                        deadlist.add(new tree(mapx, mapy, mapage));
                        i--;
                    }
                }
                season++;
            }
            if (season == 1) {
                if (!deadlist.isEmpty()) {
                    for (int i = 0; i < deadlist.size(); i++) {
                        int deadx = deadlist.get(i).x;
                        int deady = deadlist.get(i).y;
                        int deadage = deadlist.get(i).age;
                        map[deadx][deady] += deadage / 2;
                    }

                }
                season++;
                deadlist.clear();
            }
            if (season == 2) {
                int tmp = list2.size();
                for (int i = 0; i < tmp; i++) {
                    tree treetemp = list2.poll();
                    int mapx = treetemp.x;
                    int mapy = treetemp.y;
                    int mapage = treetemp.age;
                    if (mapage % 5 == 0) {
                        for (int j = 0; j < dirs.length; j++) {
                            int x = mapx + dirs[j][0];
                            int y = mapy + dirs[j][1];
                            if (isIn(x, y)) {
                                list2.add(new tree(x, y, 1));
                            }
                        }
                    }
                    list3.add(treetemp);

                }
                for (int i = 0; i < list3.size(); i++) {
                    list2.add(list3.get(i));
                }
                list3.clear();
                season++;
            }
            if (season == 3) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j] += A[i][j];
                    }
                }
            }
            K--;
        }
        System.out.println(list2.size());
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < map.length && j < map[0].length;
    }

    static class tree {
        int x;
        int y;
        int age;

        public tree(int x, int y, int age) {
            super();
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public String toString() {
            return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
        }
    }
}
