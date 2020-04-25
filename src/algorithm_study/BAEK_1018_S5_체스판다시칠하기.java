package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1018_S5_체스판다시칠하기 {
	static int N;
	static int M;
	static char[][] map;
	static char[][] map1;
	static char[][] map2;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new char[N][M];
		map1 = new char[8][8];
		map2 = new char[8][8];
		
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			map[i] = t.toCharArray();
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if((i+j)%2 == 0) {
					map1[i][j] = 'W';
					map2[i][j] = 'B';
				}else {
					map1[i][j] = 'B';
					map2[i][j] = 'W';
				}				
			}
		}
		
		int result = 9999;
		
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				int count1 = 0;
				int count2 = 0;
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if(map[k+i][l+j] != map1[k][l]) {
							count1++;
						}
						if(map[k+i][l+j] != map2[k][l]) {
							count2++;
						}
					}
				}
				int tmp =  Math.min(count1, count2);
				result = Math.min(tmp, result);
			}
		}
		System.out.println(result);

	}

}
