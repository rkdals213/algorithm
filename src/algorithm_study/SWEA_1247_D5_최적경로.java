package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_D5_최적경로 {
	static int N;
	static int [][] location;
	static int min;
	static int sx;
	static int sy;
	static int ex;
	static int ey;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			min = Integer.MAX_VALUE;
			location = new int [N][2];
			temp = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(temp.nextToken());
			sy = Integer.parseInt(temp.nextToken());
			ex = Integer.parseInt(temp.nextToken());
			ey = Integer.parseInt(temp.nextToken());
			for (int j = 0; j < N; j++) {
				location[j][0] = Integer.parseInt(temp.nextToken());
				location[j][1] = Integer.parseInt(temp.nextToken());
			}
			makePerm(0, N, new int [N], new boolean [N]);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	static void makePerm(int r, int depth, int [] result, boolean [] visited) {
		if(r == depth) {
			getDistance(result);
		}else {
			for (int i = 0; i < result.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[r] = i;
					makePerm(r+1, depth, result, visited);
					visited[i] = false;
				}
			}
		}
	}
	
	static void getDistance(int [] result) {
		int distance = 0;
		distance += Math.abs(sx-location[result[0]][0]) + Math.abs(sy-location[result[0]][1]);
		for (int i = 1; i < N; i++) {
			distance += Math.abs(location[result[i-1]][0]-location[result[i]][0]) + 
					Math.abs(location[result[i-1]][1]-location[result[i]][1]);
		}
		distance += Math.abs(ex-location[result[N-1]][0]) + Math.abs(ey-location[result[N-1]][1]);
		min = Math.min(min, distance);
	}
}
