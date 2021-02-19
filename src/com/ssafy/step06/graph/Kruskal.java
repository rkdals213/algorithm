package com.ssafy.step06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Kruskal {
    static int[] parents;
    static int[] rank;
    // 입력은 첫줄에 정점의 갯수와 간선의 갯수가 들어오고
    // 그다음줄부터 간선의 정보가 정점1 정점2 가중치로 간선의 갯수만큼 들어옴
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(temp.nextToken());
        int E = Integer.parseInt(temp.nextToken());
        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            temp = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(temp.nextToken());
            edges[i][1] = Integer.parseInt(temp.nextToken());
            edges[i][2] = Integer.parseInt(temp.nextToken());

        }

        // 간선들을 가중치 오름차순 정렬		
        Arrays.sort(edges, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        for (int i = 0; i < V; i++) {
            makeSet(i);
        }
        // 정점의 개수 -1번 반복하면서
        int cnt = 0;
        for (int i = 0; i < E; i++) {
            int a = find(edges[i][0]);
            int b = find(edges[i][1]);
            if (a == b) continue;
            union(a, b);
            result += edges[i][2];
            cnt--;
            if (cnt == V - 1) break;
        }

        // 간선이 연결하는 두 정점이 같은팀이 아니라면 한팀으로 합쳐주고 간선 선택


    }

    static void makeSet(int x) {
        parents[x] = x;
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py]) {
            parents[py] = px;
        } else {
            parents[px] = py;
        }
    }

}
