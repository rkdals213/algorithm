package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class SWEA_1251_D4_하나로2 {
    static int[] root;
    static int N;
    static int[][] V;
    static long result;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(temp.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < TC; a++) {
            result = 0;
            temp = new StringTokenizer(br.readLine());
            N = Integer.parseInt(temp.nextToken());
            V = new int[N][2];
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                V[j][0] = Integer.parseInt(temp.nextToken());
            }
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                V[j][1] = Integer.parseInt(temp.nextToken());
            }

            temp = new StringTokenizer(br.readLine());
            double E = Double.parseDouble(temp.nextToken());

            long[][] adj = new long[N][N];
            for (int j = 0; j < N; j++) {
                int sx = V[j][0];
                int sy = V[j][1];
                int sp = j;
                for (int k = 0; k < N; k++) {
                    int ex = V[k][0];
                    int ey = V[k][1];
                    int ep = k;
                    long dx = sx - ex;
                    long dy = sy - ey;
                    long distance = dx * dx + dy * dy;

                    adj[sp][ep] = adj[ep][sp] = distance;
                }
            }
            boolean[] check = new boolean[N];
            long[] key = new long[N]; // 현재 선택된 정점들로부터 도달할 수 있는 최소거리
            int[] p = new int[N]; // 최소신장트리의 구조를 저장할 배열

            Arrays.fill(key, Long.MAX_VALUE);

            // 아무거나 하나 선택 (처음 선택되는 친구가 루트이므로, 부모는 없고, 거리는 0)
            p[0] = -1;
            key[0] = 0;

            // 이미 하나 골랐으니 나머지 V-1 개를 골라보자
            for (int i = 0; i < N - 1; i++) {
                long min = Long.MAX_VALUE;
                int idx = -1;
                // 안골라진 친구들 중에서 key가 가장 작은 친구를 뽑자
                for (int j = 0; j < N; j++) {
                    if (!check[j] && key[j] < min) {
                        idx = j;
                        min = key[j];
                    }
                }
                // idx : 선택이 안된 정점중 key가 가장 작은 친구가 들어있다
                check[idx] = true;
                // idx정점에서 출발하는 모든 간선에 대해서 key를 업데이트
                for (int j = 0; j < N; j++) {
                    // check가 안되있으면서, 간선은 존재하고, 그 간선이 key값보다 작다면 key값을 업데이트
                    if (!check[j] && adj[idx][j] != 0 && key[j] > adj[idx][j]) {
                        p[j] = idx;
                        key[j] = adj[idx][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                result += key[i];
            }


            sb.append("#").append(a + 1).append(" ").append(Math.round(result * E)).append("\n");
        }
        System.out.println(sb);
    }

}
