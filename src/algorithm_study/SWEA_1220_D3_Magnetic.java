package algorithm_study;

import java.util.Scanner;

public class SWEA_1220_D3_Magnetic { // 1은 밑으로가고 2는 위로감
	static int [][] map;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");
			int N = s.nextInt();
			int result = 0;
			map = new int [N][N];
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2] = s.nextInt();
				}
			}
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					if(map[j][j2] != 0) {
						if(find(j, j2, map[j][j2])) {
							result++;
						}
					}
				}
			}
			sb.append(result/2).append("\n");		
		}
		System.out.println(sb);
	}
	public static boolean find(int i, int j, int turn) {
		if(map[i][j] == 1) {
			for (int k = i+1; k < map.length; k++) {
				if(map[k][j] == 2) {
					return true;
				}else if(map[k][j] == 1) {
					return false;
				}
			}			
		}else if(map[i][j] == 2) {			
			for (int k = i-1; k >= 0; k--) {
				if(map[k][j] == 1) {
					return true;
				}else if(map[k][j] == 2) {
					return false;
				}
			}			
		}
		return false;
	}

}
