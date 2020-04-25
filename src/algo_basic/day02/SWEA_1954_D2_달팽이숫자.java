package algo_basic.day02;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1954_D2_달팽이숫자 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	
		int [][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; // 오른쪽, 아래, 왼쪽, 위
		
		int TC = scanner.nextInt();
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append("\n");
			int N = scanner.nextInt();
			int [][] arr = new int[N][N];
			int a=0, b=0, c=0;
			
			for (int j = 0; j < N*N; j++) {	
				if(arr[a][b] == 0) {
					arr[a][b] = j+1;
					if(0 <= a+dir[c][0] && a+dir[c][0] < N && 0 <= b+dir[c][1] && b+dir[c][1] < N && arr[a+dir[c][0]][b+dir[c][1]] == 0) {					
						a+=dir[c][0];
						b+=dir[c][1];
					}
					else {
						c = (c+1)%4;
						a+=dir[c][0];
						b+=dir[c][1];
					}
				}
			}
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					sb.append(arr[j][j2]).append(" ");
				}				
				sb.append("\n");
			}			
		}
		System.out.println(sb);
	}
}
