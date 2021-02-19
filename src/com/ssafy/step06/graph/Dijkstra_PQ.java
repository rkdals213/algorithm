package com.ssafy.step06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_PQ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(temp.nextToken());
        int E = Integer.parseInt(temp.nextToken());

        List<Edge>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            temp = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(temp.nextToken())].add(new Edge(Integer.parseInt(temp.nextToken()), Integer.parseInt(temp.nextToken())));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V];
        Edge[] D = new Edge[V];
        for (int i = 0; i < V; i++) {
            if (i == 0) {
                D[i] = new Edge(i, 0);
            } else {
                D[i] = new Edge(i, Integer.MAX_VALUE);
            }
            pq.add(D[i]);
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            for (Edge e : adj[edge.v]) {
                if (!check[e.v] && D[e.v].weight > D[edge.v].weight + e.weight) {
                    D[e.v].weight = D[edge.v].weight + e.weight;
                    pq.remove(D[e.v]);
                    pq.add(D[e.v]);
                }
            }
            check[edge.v] = true;
        }

        System.out.println(Arrays.toString(D));


    }

    static class Edge implements Comparable<Edge> {
        int v, weight;

        public Edge(int v, int weight) {
            super();
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return this.weight + "";
        }
    }


}
