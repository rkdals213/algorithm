package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_D2_파리퇴치 {
	static int [][] flymap;
	static int [][] dirs = {{1,0},{0,1},{1,1}};
	
	public static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<flymap.length && j<flymap[0].length;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < TC; i++) {			
			sb.append("#").append(i+1).append(" ");
			int max = Integer.MIN_VALUE;
			StringTokenizer temp = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(temp.nextToken()); // 상자의 가로칸수
			int M = Integer.parseInt(temp.nextToken()); // 상자의 세로칸수
			flymap = new int [N][N];
			
			for (int j = 0; j < N; j++) {
				temp = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < flymap[j].length; j2++) {
					flymap[j][j2] = Integer.parseInt(temp.nextToken());
				}
			}
			for (int j = 0; j < flymap.length; j++) {
				for (int j2 = 0; j2 < flymap.length; j2++) {
					int sum = 0;
					
					for (int k = j; k < j + M; k++) {
						for (int k2 = j2; k2 < j2 + M; k2++) {
							if(isIn(k,k2)) {
								sum += flymap[k][k2];
							}
						}
					}
					if(sum > max) max = sum;
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
