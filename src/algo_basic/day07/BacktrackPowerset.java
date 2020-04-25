package algo_basic.day07;

import java.util.Arrays;

public class BacktrackPowerset {
	static char [] src = {'A', 'B','C'}; // 사용가능한 종류는?
	static boolean [] childs = {true, false}; // 자식들의 배치 상태를 저장할 배열 만들기
	static boolean [] subset = new boolean[src.length]; 
	
	public static void dfs(int k, int input) {
		if(k == input) {
			printSolution();
		}else {
			// 탐색 - 다음 자식으로.
			for (int i = 0; i < childs.length; i++) {
				subset[k]=childs[i]; // 자식을 넣어본다.
				dfs(k+1, input);
			}			
		}
	}
	
	private static void printSolution() {
		for (int i = 0; i < subset.length; i++) {
			if(subset[i]) {
				System.out.print(src[i] + " ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		dfs(0,src.length);

	}

}
