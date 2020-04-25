package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4615_D3_재미있는오셀로게임 {
	static int [][] dirsC = {{0,-1}, {1,0}, {0,1}, {-1,0}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int TC = s.nextInt();		
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			int N = s.nextInt();
			int [][] board = new int [N][N];
			board[N/2][N/2] = 2;
			board[(N/2)-1][(N/2)-1] = 2;
			board[(N/2)-1][N/2] = 1;
			board[N/2][(N/2)-1] = 1;
			int M = s.nextInt(); // 턴 횟수
			////////////////////////////////////////////////
			for (int j = 0; j < M; j++) {
				int x = s.nextInt();
				int y = s.nextInt();
				int turn = s.nextInt();
				x-=1;
				y-=1;
				if(x >= N || y >= N) continue; 
				if(turn != 1 && turn != 2) continue;
				board = find(board, x, y, turn);					
			}			
			sb.append(findturn(board, 1)).append(" ").append(findturn(board, 2)).append('\n');
		}
		System.out.println(sb);
	}
	public static int findturn(int [][] board, int turn) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == turn) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	public static boolean isIn(int [][] board, int r, int c) {
		return 0<=r && 0<=c && r<board.length && c<board[0].length;
	}
	
	public static int [][] find(int [][] board, int x, int y, int turn) {
		board[x][y] = turn;		
		if(turn == 1) {
			for (int i = 0; i < dirsC.length; i++) {
				int xr = x;
				int yc = y;
				if(isIn(board, xr+dirsC[i][0], yc+dirsC[i][1]) && isIn(board, xr, yc)) {
					xr += dirsC[i][0];
					yc += dirsC[i][1];	
					while(board[xr][yc] == 2) {
						if(isIn(board, xr+dirsC[i][0], yc+dirsC[i][1]) && isIn(board, xr, yc)) {
							xr += dirsC[i][0];
							yc += dirsC[i][1];	
							if(board[xr][yc] == 1) {
								board = flip(board, x, y, xr, yc, turn, i);
								//break;
							}else if(board[xr][yc] == 0) {
								//break;
							}else {
								//break;
							}
						}else {
							break;
						}
					}
				}				
			}
		}else if(turn == 2) {
			for (int i = 0; i < dirsC.length; i++) {
				int xr = x;
				int yc = y;
				if(isIn(board, x+dirsC[i][0], y+dirsC[i][1]) && isIn(board, xr, yc)) {
					xr += dirsC[i][0];
					yc += dirsC[i][1];	
					while(board[xr][yc] == 1) {
						if(isIn(board, xr+dirsC[i][0], yc+dirsC[i][1]) && isIn(board, xr, yc)) {
							xr += dirsC[i][0];
							yc += dirsC[i][1];	
							if(board[xr][yc] == 2) {
								board = flip(board, x, y, xr, yc, turn, i);
								//break;
							}else if(board[xr][yc] == 0) {
								//break;
							}else {
								//break;
							}
						}else {
							break;
						}
					}
				}				
			}
		}
		return board;		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public static int [][] flip(int [][] board, int x, int y, int xr, int yc, int turn, int i) {
		if(y != yc && x != xr) {
			while(y-yc != 0) {
				board[x][y] = turn;
				x += dirsC[i][0];
				y += dirsC[i][1];
			}
		}
		if(x != xr) {
			while(x-xr != 0) {
				board[x][y] = turn;
				x += dirsC[i][0];
			}
		}
		if(y != yc) {
			while(y-yc != 0) {
				board[x][y] = turn;
				y += dirsC[i][1];
			}
		}
		return board;
	}
	
}
