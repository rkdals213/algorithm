package algo_ad.day02;

import java.util.Arrays;

public class P165_NQueen {
	public static void main(String[] args) {
		int [] queen = new int[4];
		DFS(0, new int [4], 4, new boolean[4]);
	}
	static void DFS(int c, int [] result, int t, boolean [] visited) {
		if(c == t) {
			boolean flag = false;
//			for (int i = 0; i < result.length-1; i++) {
//				if(Math.abs(result[i] - result[i+1]) == 1) {
//					flag = true;
//					break;
//				}			
//			}
			if(!flag) {
				System.out.println(Arrays.toString(result));
			}			
		}else {			
			outer : for (int i = 0; i < result.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[c] = i;
					if(c > 2) {
						for (int j = 0; j < result.length-1; j++) {
							if(Math.abs(result[j] - result[j+1]) == 1) {
								visited[i] = false;
								continue outer;
							}			
						}
					}				
					DFS(c+1, result, t, visited);
					visited[i] = false;
				}
			}
		}
	}
}
