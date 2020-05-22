package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17069_G5_파이프옮기기2 {
	static int N;
	static long [][][] map;
	static boolean [][] wall;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		map = new long [N][N][3];
		wall = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(Integer.parseInt(temp.nextToken()) == 1) {
					wall[i][j] = true;
				}
			}
		}

		for (int i = 1; i < N; i++) {
			if(wall[0][i]) break;
			map[0][i][0] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(!wall[i][j]) {
					if(!wall[i][j-1]) map[i][j][0] = map[i][j-1][0] + map[i][j-1][1];
					if(!wall[i][j-1] && !wall[i-1][j] && !wall[i-1][j-1]) map[i][j][1] = map[i-1][j-1][0] + map[i-1][j-1][1] + map[i-1][j-1][2];
					if(!wall[i-1][j]) map[i][j][2] = map[i-1][j][1] + map[i-1][j][2];		
				}						
			}
		}

		long result = map[N-1][N-1][0] + map[N-1][N-1][1] + map[N-1][N-1][2];
		System.out.println(result);
	}

}
