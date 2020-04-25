package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEK_2447_S1_별찍기 {
	static char [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new char [N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], ' ');
		}
		star(0, 0, N);
		for (int i = 0; i < N; i++) {
			sb.append(map[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void star(int x, int y, int n) {
		if(n == 1) {
			map[x][y] = '*';
			return;
		}
		int k = n/3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i!=1 || j!=1) {
					star(x+(i*k), y+(j*k), k);
				}
			}
		}			
	}
}
