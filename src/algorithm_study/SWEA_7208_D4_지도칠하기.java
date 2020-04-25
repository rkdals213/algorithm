package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7208_D4_지도칠하기 {
	static int N;
	static int [][] graph;
	static int [] color;
	static int count;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			color = new int [N];
			StringTokenizer temp = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				color[j] = Integer.parseInt(temp.nextToken());
			}
			
			count = 0;
			for (int j = 0; j < N; j++) {
				temp = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					graph[j][k] = Integer.parseInt(temp.nextToken());
				}
			}		
			find();			
		}
		System.out.println(sb);
	}
	
	static void find() {
		boolean [] visited = new boolean [N]; // 나라 방문 여부
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				for (int j = 0; j < N; j++) {
					if(graph[i][j] == 1 && !visited[j]) {
						if(color[i] == color[j]) {
							visited[j] = true;
							count++;
						}
					}
				}
			}		
		}
		sb.append(count).append("\n");
	}
	
	
}
