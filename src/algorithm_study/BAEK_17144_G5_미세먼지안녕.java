package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_17144_G5_미세먼지안녕 {
	static int [][] map;
	static int [][] copymap;
	static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static int D = dirs.length;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp;
		
		temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		int T = Integer.parseInt(temp.nextToken());
		map = new int [N][M];
		copymap = new int [N][M];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			rotate();
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum+= map[i][j];
			}
		}
		System.out.println(sum+2);
	}
	
	public static void spread() {
		for (int i = 0; i < N; i++) {			
			System.arraycopy(map[i], 0, copymap[i], 0, M);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int count = 1;
				if(map[i][j] > 0) {					
					for (int j2 = 0; j2 < D; j2++) {
						int x = i+dirs[j2][0];
						int y = j+dirs[j2][1];
						if(isIn(x, y) && map[x][y] != -1) {
							count++;
							copymap[x][y] += map[i][j] / 5;
						}
					}
					copymap[i][j] = copymap[i][j] - ((map[i][j] / 5)*(count-1));
				}
			}
		}
	
	}
	
	public static void rotate() {
		int minus = find();
		int [][] dir1 = {{0,1},{-1,0},{0,-1},{1,0}};
		int [][] dir2 = {{0,1},{1,0},{0,-1},{-1,0}};
		for (int i = 0; i < N; i++) {			
			System.arraycopy(copymap[i], 0, map[i], 0, M);
		}
		int x = minus;
		int y = 1;
		int x2 = minus+1;
		int y2 = 1;
		map[x][y] = 0;
		map[x2][y2] = 0;
		int count = 0;
		int count2 = 0;
		while(true) {
			x += dir1[count][0];
			y += dir1[count][1];			
			if(isIn(x, y)) {
				if(copymap[x][y] == -1) {
					break;
				}
				if(count == 0) {
					map[x][y] = copymap[x][y-1];
				}else if(count == 1) {
					map[x][y] = copymap[x+1][y];
				}else if(count == 2) {
					map[x][y] = copymap[x][y+1];
				}else if(count == 3) {
					map[x][y] = copymap[x-1][y];
				}				
			}else {
				x -= dir1[count][0];
				y -= dir1[count][1];
				count++;
			}	
		}
		while(true) {
			x2 += dir2[count2][0];
			y2 += dir2[count2][1];
			if(isIn(x2, y2)) {
				if(copymap[x2][y2] == -1) {
					break;
				}
				if(count2 == 0) {
					map[x2][y2] = copymap[x2][y2-1];
				}else if(count2 == 1) {
					map[x2][y2] = copymap[x2-1][y2];
				}else if(count2 == 2) {
					map[x2][y2] = copymap[x2][y2+1];
				}else if(count2 == 3) {
					map[x2][y2] = copymap[x2+1][y2];
				}				
			}else {
				x2 -= dir2[count2][0];
				y2 -= dir2[count2][1];
				count2++;
			}			
		}
		
	}
	
	public static int find() {
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(copymap[i][j] == -1) {
					result = i;
					return result;
				}
			}
		}
		return result;
	}
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}

}
