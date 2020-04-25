package algorithm_study;

import java.util.Scanner;

public class SWEA_2805_D3_농작물수확하기 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		int [][] board;		
		int TC = s.nextInt();	
		for (int i = 0; i < TC; i++) {	
			int N = s.nextInt();
			int sum = 0;
			sb.append("#").append(i+1).append(" ");
			if(N==0) N=1;
			board = new int [N][N];
			for (int j = 0; j < board.length; j++) {
				String temp = s.next();				
				for (int j2 = 0; j2 < board.length; j2++) {
					board[j][j2] = (int)(temp.charAt(j2)-'0');
				}
			}
			for (int j = 0; j < board.length; j++) {
				if(j <= N/2) {
					for (int j2 = N/2 - j; j2 <= N/2 + j; j2++) {
						sum += board[j][j2];
					}
				}else {
					for (int j2 = j - N/2; j2 <= N/2 + N - j - 1; j2++) {
						sum += board[j][j2];
					}
				}
			}			
			
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

