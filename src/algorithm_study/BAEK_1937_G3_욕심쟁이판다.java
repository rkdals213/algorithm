package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1937_G3_욕심쟁이판다 {
	static int N;
	static int [][] map;
	static int [][] dp;
	static int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		dp = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
				dp[i][j] = -1;
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dp[i][j] == -1) result = Math.max(DFS(i,j), result);
			}
		}
		
		System.out.println(result);
	}
	
	static int DFS(int i, int j) {
		if(dp[i][j] != -1) return dp[i][j];
		
		dp[i][j] = 0;
		
		boolean f = false;
		
		for (int k = 0; k < 4; k++) {
			int x = i+dir[k][0];
			int y = j+dir[k][1];
			if(isIn(x,y) && map[x][y] > map[i][j]) {
				dp[i][j] = Math.max(DFS(x, y)+1, dp[i][j]);
				f = true;
			}
		}
		if(f) return dp[i][j];
		else return dp[i][j] = 1;
	}
	
	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}
}
