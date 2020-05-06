package com.ssafy.step06.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(temp.nextToken());
		int E = Integer.parseInt(temp.nextToken());
		
		int [][] adj = new int[V][V];
		int [] D = new int[V];
		
		
		for (int i = 0; i < E; i++) {
			temp = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(temp.nextToken())-1][Integer.parseInt(temp.nextToken())-1] = Integer.parseInt(temp.nextToken());
		}
		
		Arrays.fill(D, Integer.MAX_VALUE);
		boolean[] check = new boolean [V];
		D[0] = 0;
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			for (int j = 0; j < V; j++) {
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			
			for (int j = 0; j < V; j++) {
				// 아직 처리하지 않았으면서, 경로가 존재하고, D[index]+adj[index][j] < D[j]
				if(!check[j] && adj[index][j] != 0 && D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j];
				}
			}
			check[index] = true;
		}
		
		System.out.println(Arrays.toString(D));

	}

}
