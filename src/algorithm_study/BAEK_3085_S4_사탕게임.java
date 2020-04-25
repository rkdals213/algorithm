package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_3085_S4_사탕게임 {
	static int N;
	static char [][] map;
	static int[][] dirs = { { 1, 0 }, { 0, 1 } };
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			map[i] = temp.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					if(isIn(i+dirs[j2][0],j+dirs[j2][1])) {							
						char [][] mapcopy = new char[N][N];
						for (int k = 0; k < N; k++) {
							mapcopy[k] = map[k].clone();
						}
						char temp = mapcopy[i][j];
						mapcopy[i][j] = mapcopy[i+dirs[j2][0]][j+dirs[j2][1]];
						mapcopy[i+dirs[j2][0]][j+dirs[j2][1]] = temp;
						find(mapcopy);
					}			
				}	
			}
		}	
		System.out.println(max);
	}

	static void find(char [][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char check = m[i][j];				
				for (int k = 0; k < 2; k++) {
					int x = i;
					int y = j;
					int count = 1;
					while(isIn(x + dirs[k][0],y + dirs[k][1])) {
						x = x + dirs[k][0];
						y = y + dirs[k][1];
						if(m[x][y] == check) {
							count++;
						}else {
							break;
						}
					}
					max = Math.max(max, count);

				}

			}
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}

}
