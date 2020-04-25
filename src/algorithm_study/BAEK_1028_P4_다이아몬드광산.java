package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1028_P4_다이아몬드광산 {
	static int N,M;
	static char [][] map;
	static int max = 0;
	private static int[][] dirs = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } }; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new char [N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			map[i] = input.toCharArray();
		}
		for (int i = 0; i < N-max; i++) {
			for (int j = 0; j < M-max; j++) {
				if(map[i][j] != '0') {
					int tmax = 0;
					outer:for (int k = 0; k < dirs.length; k++) {
						int x = i;
						int y = j;
						int t = 0;
						while(isIn(x+dirs[k][0], y+dirs[k][1]) && map[x+dirs[k][0]][y+dirs[k][1]] != '0') {
							x+=dirs[k][0];
							y+=dirs[k][1];
							t++;
							if(t >= (N/2)+1 || t >= (M/2)+1) {
								tmax = Math.min((N/2)+1, (M/2)+1);
								break outer;
							}
						}
						tmax = Math.max(tmax, t);
						
					}
					
					for (int l = tmax; l >= max; l--) {
						int x = i;
						int y = j;
						boolean flag = true;
						outer: for (int k = 0; k < dirs.length; k++) {		
							int count = 0;
							while(count < l) {
								if(isIn(x+dirs[k][0], y+dirs[k][1]) && map[x+dirs[k][0]][y+dirs[k][1]] != '0') {
									x+=dirs[k][0];
									y+=dirs[k][1];
								}else {
									flag = false;
									break outer;
								}
								count++;
							}							
						}
						if(flag) {
							max = Math.max(max, l+1);
							break;
						}					
					}					
				}
			}
		}
		System.out.println(max);

	}
	
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}

}
