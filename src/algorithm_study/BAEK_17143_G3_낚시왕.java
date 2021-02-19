package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_17143_G3_낚시왕 {
    static int N;
    static int M;
    static int sharknum;
    static int sum = 0;
    static ArrayList<shark> list = new ArrayList<>();
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        sharknum = Integer.parseInt(temp.nextToken());

        int fisherman = -1;


        for (int i = 0; i < sharknum; i++) {
            temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken()) - 1;
            int y = Integer.parseInt(temp.nextToken()) - 1;
            int speed = Integer.parseInt(temp.nextToken());
            int d = Integer.parseInt(temp.nextToken()) - 1;
            int weight = Integer.parseInt(temp.nextToken());

            list.add(new shark(x, y, speed, d, weight, i + 1));
        }


        while (fisherman < M - 1) {
            visited = new int[N * M][2];
            fisherman++;
            List<Integer> eated = new ArrayList<>();

            int mini = 0;
            int minlocation = Integer.MAX_VALUE;
            int minweight = Integer.MAX_VALUE;
            boolean f = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).location % M == fisherman) {
                    if (list.get(i).location < minlocation) {
                        minlocation = list.get(i).location;
                        mini = i;
                        minweight = list.get(i).weight;
                        f = true;
                    }
                }
            }
            if (f) {
                list.remove(mini);
                sum += minweight;
            }

            for (int i = 0; i < list.size(); i++) {
                int l = list.get(i).location;
                int d = list.get(i).d;
                int speed = list.get(i).speed;
                int idx = list.get(i).idx;
                int left = (l / M) * M;
                int right = ((l / M) + 1) * M - 1;
                int down = l % M;
                int up = down + M * (N - 1);

                if (d == 0) {
                    int key = 1;
                    speed = speed % (2 * (N - 1));
                    speed *= M;
                    if (l - speed < down) {
                        l = down + (speed - l + down);
                        key *= -1;
                    } else {
                        l = l - speed;
                    }
                    if (l > up) {
                        l = up - (l - up);
                        key *= -1;
                    }
                    if (key < 0) {
                        list.get(i).d = 1;
                    }
                    list.get(i).location = l;
                } else if (d == 1) {
                    int key = -1;
                    speed = speed % (2 * (N - 1));
                    speed *= M;
                    if (l + speed > up) {
                        l = up - (speed - up + l);
                        key *= -1;
                    } else {
                        l = l + speed;
                    }
                    if (l < down) {
                        l = down + (down - l);
                        key *= -1;
                    }
                    if (key > 0) {
                        list.get(i).d = 0;
                    }
                    list.get(i).location = l;
                } else if (d == 2) {
                    int key = -1;
                    speed = speed % (2 * (M - 1));
                    if (l + speed > right) {
                        l = right - (speed - right + l);
                        key *= -1;
                    } else {
                        l = l + speed;
                    }
                    if (l < left) {
                        l = left + (left - l);
                        key *= -1;
                    }
                    if (key > 0) {
                        list.get(i).d = 3;
                    }
                    list.get(i).location = l;
                } else if (d == 3) {
                    int key = 1;
                    speed = speed % (2 * (M - 1));
                    if (l - speed < left) {
                        l = left + (speed - l + left);
                        key *= -1;
                    } else {
                        l = l - speed;
                    }
                    if (l > right) {
                        l = right - (l - right);
                        key *= -1;
                    }
                    if (key < 0) {
                        list.get(i).d = 2;
                    }
                    list.get(i).location = l;
                }

                if (visited[l][0] == 0) {
                    list.get(i).location = l;
                    visited[l][0] = list.get(i).weight;
                    visited[l][1] = idx;
                } else {
                    if (visited[l][0] > list.get(i).weight) {
                        eated.add(idx);
                    } else {
                        int k = visited[l][1];
                        visited[l][0] = list.get(i).weight;
                        visited[l][1] = idx;
                        list.get(i).location = l;
                        eated.add(k);

                    }
                }
            }
            for (int a = 0; a < eated.size(); a++) {
                for (int j = 0; j < list.size(); j++) {
                    if (eated.get(a) == list.get(j).idx) {
                        list.remove(j);
                        j--;
                    }
                }
            }
            visited = new int[N * M][2];

        }
        System.out.println(sum);
    }

    static class shark {
        int location;
        int speed;
        int d;
        int weight;
        int idx;

        public shark(int x, int y, int speed, int d, int weight, int idx) {
            super();
            this.location = x * M + y;
            this.speed = speed;
            this.d = d;
            this.weight = weight;
            this.idx = idx;
        }
    }
}
