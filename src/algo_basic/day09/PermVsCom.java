package algo_basic.day09;

import java.util.Arrays;

public class PermVsCom {
	static char [] src = {'A','B','C','D'};
	public static void main(String[] args) {
		// 위 배열로 생성할 수 있는 순열을 만들어서 출력하시오
		boolean [] visited = new boolean[4];
		char [] result = new char[4];
		//DFS(visited, 0, 4, result);
		makeCombination(2, new char[4], 0, 0);
	}
	
	public static void DFS(boolean [] visited, int count, int depth, char [] result) {
		if(count == depth) {
			System.out.println(Arrays.toString(result));
		}else {
			for (int i = 0; i < src.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[count] = src[i];
					DFS(visited, count+1, depth, result);
					visited[i] = false;
				}
			}
		}
	} 
	public static void makeCombination(int r, char [] temp, int current, int start) {
		if(current == r) {
			System.out.println(Arrays.toString(temp));
		}else {
			for (int i = start; i < src.length; i++) {
				temp[current] = src[i];
				makeCombination(r, temp, current+1, i+1);
			}
		}
	}
}
