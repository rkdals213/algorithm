package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1798_D5_범준이의여행계획 {
    static int N, M;
    static int[][] map;
    static int[][] perpose; // 1은 공항, 2는 놀곳, 3은 호텔
    static boolean[] visited;
    static int result = 0;
    static int start;
    static List<Integer> resultPath;
    static List<Integer> path;
    static int hotelList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer temp = new StringTokenizer(br.readLine());
            N = Integer.parseInt(temp.nextToken());
            M = Integer.parseInt(temp.nextToken());
            map = new int[N][N];
            perpose = new int[N][3];
            visited = new boolean[N];
            for (int i = 0; i < N - 1; i++) {
                temp = new StringTokenizer(br.readLine());
                for (int j = i + 1; j < N; j++) {
                    map[i][j] = Integer.parseInt(temp.nextToken());
                    map[j][i] = map[i][j];
                }
            }
            hotelList = 0;
            for (int i = 0; i < N; i++) {
                temp = new StringTokenizer(br.readLine());
                String t = temp.nextToken();
                if (t.equals("P")) {
                    perpose[i][0] = 2;
                    perpose[i][1] = Integer.parseInt(temp.nextToken());
                    perpose[i][2] = Integer.parseInt(temp.nextToken());
                } else if (t.equals("A")) {
                    perpose[i][0] = 1;
                    start = i;
                } else if (t.equals("H")) {
                    perpose[i][0] = 3;
                    hotelList++;
                }
            }
            result = 0;
            resultPath = new ArrayList<>();
            path = new ArrayList<>();
            DFS(0, 540, start, 0);
            sb.append(result).append(" ");
            for (int i = 0; i < resultPath.size(); i++) {
                sb.append(resultPath.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    // time = 540
    static void DFS(int day, int time, int cur, int happyness) {
        boolean flag = false;
        for (int i = 1; i < N - hotelList; i++) {
            if (i == cur || visited[i]) continue;
            int timeToSpend = perpose[i][1] + map[cur][i];
            int expectedHappyness = perpose[i][2];
            if (day < M - 1 && time >= timeToSpend) {
                flag = true;
                visited[i] = true;
                path.add(i + 1);
                DFS(day, time - timeToSpend, i, happyness + expectedHappyness);
                visited[i] = false;
                path.remove(path.size() - 1);
            } else if (day == M - 1 && time >= timeToSpend + map[i][0]) {
                flag = true;
                visited[i] = true;
                path.add(i + 1);
                DFS(day, time - timeToSpend, i, happyness + expectedHappyness);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
        if (!flag) {
            if (day == M - 1) {
                if (result < happyness) {
                    result = happyness;
                    resultPath = new ArrayList<>();
                    for (int i = 0; i < path.size(); i++) {
                        resultPath.add(path.get(i));
                    }
                    resultPath.add(1);
                }
            } else {
                for (int j = N - hotelList; j < N; j++) {
                    int timeToMove = map[cur][j];
                    if (time >= timeToMove) {
                        path.add(j + 1);
                        DFS(day + 1, 540, j, happyness);
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
    }
}
