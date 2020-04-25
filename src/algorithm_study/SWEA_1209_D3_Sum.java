package algorithm_study;

import java.util.Scanner;

public class SWEA_1209_D3_Sum {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		int [][] board;		
		for (int i = 0; i < 10; i++) {
			int TC = s.nextInt();	
			int max = Integer.MIN_VALUE;
			int temp = 0;
			sb.append("#").append(i+1).append(" ");
			board = new int [100][100];
			for (int j = 0; j < board.length; j++) {
				temp = 0;
				for (int j2 = 0; j2 < board.length; j2++) {
					board[j][j2] = s.nextInt();
					temp += board[j][j2]; 
				}
				if(temp > max) max = temp;
			}
			for (int j = 0; j < board.length; j++) {
				temp = 0;
				for (int j2 = 0; j2 < board.length; j2++) {
					temp += board[j2][j]; 
				}
				if(temp > max) max = temp;
			}
			for (int j = 0; j < board.length; j++) {
				temp = 0;				
				temp += board[j][j]; 
				if(temp > max) max = temp;
			}
			for (int j = 0; j < board.length; j++) {
				temp = 0;				
				temp += board[j][99-j]; 
				if(temp > max) max = temp;
			}		
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
