package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14503_G5_로봇청소기 {
	static int N;
	static int M;
	static int [][] dirs = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int[N][M];
		temp = new StringTokenizer(br.readLine());
		int SX = Integer.parseInt(temp.nextToken());
		int SY = Integer.parseInt(temp.nextToken());
		int D = Integer.parseInt(temp.nextToken());
		if(D == 0) {
			D = 0;
		}else if(D == 1) {
			D = 3;
		}else if(D == 2) {
			D = 2;
		}else if(D == 3) {
			D = 1;
		}
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		map[SX][SY] = 2;
		int clean = 1;
		while(true) {	
			int k = D;
			for (int i = D; i < dirs.length+D; i++) {
				int x = SX+dirs[i%4][0];
				int y = SY+dirs[i%4][1];
				if(isIn(x,y) && map[x][y] == 0) {
					SX = x;
					SY = y;
					map[x][y] = 2;
					D = i+1;		
					clean++;
					break;
				}
			}
			if(D == k) {
				if(D==0) {
					break;
				}
				if(isIn(SX-dirs[(D-1)%4][0], SY-dirs[(D-1)%4][1]) && map[SX-dirs[(D-1)%4][0]][SY-dirs[(D-1)%4][1]] != 0) {
					SX -= dirs[(D-1)%4][0];
					SY -= dirs[(D-1)%4][1];
					if(map[SX][SY] == 1) {
						break;
					}
				}				
			}
		}
		System.out.println(clean);
	}	

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
	}


}
