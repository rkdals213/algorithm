package algo_basic.day06;

import java.util.Arrays;

public class NQueen1 {
	private static int size = 4;
	private static int [][] map = new int[size][size];
	private static int cnt=0;
	private static void dfs(int row) {
		if(row == size) {
			System.out.println("맨 마지막 - 결과 출력 " + ++cnt);			
			for (int[] rowarray : map) {
				System.out.println(Arrays.toString(rowarray));
			}
			//System.exit(0);		
			return;
		}else {
			for (int i = 0; i < size; i++) {
				// 해당 컬럼에 퀸 두기
				map[row][i] = 1;
				if(isPromising(row+1)){
					dfs(row+1);
				}				
				map[row][i] = 0;
			}
		}
	}
	// 마지막까지 돌을 두었으니 이행동이 적합했는지 생각해보자
	private static boolean isPromising(int row) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if(map[i][j]==1) {		

					// 위쪽, 대각선에 누가 없나?
					for (int j2 = 1; j2 <= i ; j2++) {
						if(map[i-j2][j]==1) {  // 위로 찾기
							return false;
						}
						// 왼쪽 대각선
						if(j-j2>=0 && map[i-j2][j-j2]==1) {
							return false;
						}
						// 오른쪽 대각선
						if(j+j2<size && map[i-j2][j+j2]==1) {
							return false;
						}
					}
				}
			}
		}
		
		return true;		
	}
	public static void main(String[] args) {
		dfs(0);	

	}
}
