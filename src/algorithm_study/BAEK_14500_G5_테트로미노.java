package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14500_G5_테트로미노 {
	static int N;
	static int M;
	static int [][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int [][] map;
	static int result = 0;
	static boolean [][] visited; 
	static int [][][] Oshape = {
			{{0,0},{0,1},{0,2},{1,1}},
			{{0,0},{1,0},{2,0},{1,1}},
			{{0,0},{0,1},{0,2},{-1,1}},
			{{0,0},{2,0},{1,0},{1,-1}}
			};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				DFS(i, j, 1, map[i][j]);
				DFS2(i, j);
				visited[i][j] = false;
			}
		}
		System.out.println(result);
	}
	
	static void DFS(int sx, int sy, int depth, int sum) {
		if(depth == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = 0; i < dirs.length; i++) {
			int x = sx + dirs[i][0];
			int y = sy + dirs[i][1];
			if(isIn(x, y)) {
				if(!visited[x][y]) {
					visited[x][y] = true;
					DFS(x, y, depth+1, sum+map[x][y]);
					visited[x][y] = false;
				}
			}
		}
		
	}
	
	static void DFS2(int sx, int sy) {
		
		for (int i = 0; i < Oshape.length; i++) {
			int sum = 0;
			for (int j = 0; j < Oshape[i].length; j++) {
				int x = sx + Oshape[i][j][0];
				int y = sy + Oshape[i][j][1];
				if(isIn(x,y)) {
					sum += map[x][y];
				}
			}
			result = Math.max(result, sum);
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}
