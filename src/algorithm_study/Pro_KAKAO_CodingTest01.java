package algorithm_study;

import java.util.ArrayList;
import java.util.List;

public class Pro_KAKAO_CodingTest01 {
	static int N;
	static List<Integer> list = new ArrayList<>();
	static int listdepth = -1;
	public static void main(String[] args) {
		int [][] board1 = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//		int [][] board1 = {{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1},{0,2,3,4,5}};
		int [] moves1 = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board1, moves1));

	}
	
	static int solution(int[][] board, int[] moves) {
		N = board.length;
        int answer = 0;
        int [] height = getheight(board);        
        
        for (int i = 0; i < moves.length; i++) {
			int key = moves[i]-1;
			if(height[key] == 5) {
				continue;
			}
			int get = board[height[key]][key];
			
			if(listdepth == -1) {
				list.add(get);
				listdepth++;
				board[height[key]][key] = 0;
				height[key]++;
			}
			else if(list.get(listdepth) == get) {
				list.remove(listdepth);
				listdepth--;
				answer += 2;
				board[height[key]][key] = 0;
				height[key]++;
			}else {
				list.add(get);
				listdepth++;
				board[height[key]][key] = 0;
				height[key]++;
			}
			
		}
        
        return answer;
    }
	
	
	static int [] getheight(int[][] board) {
		int [] getheight = new int [N];
		for (int i = 0; i < N; i++) {
			getheight[i] = N;
		}
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(board[i][j] != 0) {
					getheight[j] = i;
					break;
				}
			}
		}
		return getheight;
	}

}
