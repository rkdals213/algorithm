package com.ssafy.step06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(temp.nextToken());
        int E = Integer.parseInt(temp.nextToken());
        int[][] adj = new int[V][V];
        for (int i = 0; i < E; i++) {
            temp = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(temp.nextToken());
            int b = Integer.parseInt(temp.nextToken());
            int c = Integer.parseInt(temp.nextToken());
            adj[a][b] = c;
            adj[b][a] = c;
        }

        boolean[] check = new boolean[V];
        int[] key = new int[V]; // 현재 선택된 정점들로부터 도달할 수 있는 최소거리
        int[] p = new int[V]; // 최소신장트리의 구조를 저장할 배열

        Arrays.fill(key, Integer.MAX_VALUE);

        // 아무거나 하나 선택 (처음 선택되는 친구가 루트이므로, 부모는 없고, 거리는 0)
        p[0] = -1;
        key[0] = 0;

        // 이미 하나 골랐으니 나머지 V-1 개를 골라보자
        for (int i = 0; i < V - 1; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            // 안골라진 친구들 중에서 key가 가장 작은 친구를 뽑자
            for (int j = 0; j < V; j++) {
                if (!check[j] && key[j] < min) {
                    idx = j;
                    min = key[j];
                }
            }
            // idx : 선택이 안된 정점중 key가 가장 작은 친구가 들어있다
            check[idx] = true;
            // idx정점에서 출발하는 모든 간선에 대해서 key를 업데이트
            for (int j = 0; j < V; j++) {
                // check가 안되있으면서, 간선은 존재하고, 그 간선이 key값보다 작다면 key값을 업데이트
                if (!check[j] && adj[idx][j] != 0 && key[j] > adj[idx][j]) {
                    p[j] = idx;
                    key[j] = adj[idx][j];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < V; i++) {
            result += key[i];
        }
        System.out.println(result);
        System.out.println(Arrays.toString(p));

    }

}
