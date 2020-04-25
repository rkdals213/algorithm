package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14499_G5_주사위굴리기 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		int x = Integer.parseInt(temp.nextToken());
		int y = Integer.parseInt(temp.nextToken());
		int k = Integer.parseInt(temp.nextToken());
		map = new int[N][M];
		int [] move = new int [k];
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			move[i] = Integer.parseInt(temp.nextToken());
		}
		
		
		

	}

}
