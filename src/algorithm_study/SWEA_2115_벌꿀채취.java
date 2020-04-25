package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int k = 0; k < TC; k++) {
			max = 0;
			sb.append("#").append(k+1).append(" ");
			temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			M = Integer.parseInt(temp.nextToken());
			C = Integer.parseInt(temp.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				temp = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			
			combination(0, 2, new int [2], 0);
			sb.append(max).append("\n");
		}
	
		System.out.println(sb);

	}
	
	static void combination(int r, int depth, int [] result, int start) {
		if(r == depth) {
			collect(result);
		}else {
			for (int i = start; i < N*N-1; i++) {
				if(isIn(i)) {
					result[r] = i;
					combination(r+1, depth, result, i+M);
				}				
			}
		}
	}
	
	static int subset(int [] bottle) {
		int powermaxtemp = 0;
		for (int i = 0; i < (1<<M); i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < bottle.length; j++) {
				if((i & 1<<j) > 0) {
					subset.add(bottle[j]);
				}
			}
			int t = 0;
			int powert = 0;
			for (int j = 0; j < subset.size(); j++) {
				if(subset.get(j) > 9) {
					t+= 9;
				}else {
					t += subset.get(j);
				}
				powert += subset.get(j)*subset.get(j);
			}
			if(t <= C) {
				powermaxtemp = Math.max(powermaxtemp, powert);			
			}				
		}
		return powermaxtemp;		
	}
	
	static void collect(int [] input) {
		int result = 0;
		for (int i = 0; i < 2; i++) {
			int sum = 0;
			int powersum = 0;
			int x = input[i]/N;
			int y = input[i]%N;			
			for (int j = 0; j < M; j++) {
				sum += map[x][y+j];
				powersum += map[x][y+j]*map[x][y+j];
			}
			if(sum > C) {
				int bottle [] = new int [M];
				for (int j = 0; j < M; j++) {
					bottle[j] = map[x][y+j];
				}
				result += subset(bottle);
			}else {
				result += powersum;
			}			
		}
		max = Math.max(result, max);
	}
	
	
	static boolean isIn(int x) {
		int right = (x/N)*N + N - 1;
		return x+M-1 <= right;
	}

}
