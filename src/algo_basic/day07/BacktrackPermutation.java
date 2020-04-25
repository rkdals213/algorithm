package algo_basic.day07;

public class BacktrackPermutation {
	static int [] childs = {1, 2, 3}; // 사용가능한 종류는?
	
	static int [] subset = new int[childs.length]; 
	static boolean [] visited = new boolean[childs.length];
	static int [] temp = new int[childs.length]; 
	public static void dfs(int k, int input) {
		if(k == input) {
			printSolution();
		}else {
			// 탐색 - 다음 자식으로.
			for (int i = 0; i < childs.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					temp[k]=childs[i];
					dfs(k+1, input);
					visited[i] = false;
				}
			}			
		}
	}
	
	private static void printSolution() {
		for (int i = 0; i < subset.length; i++) {
			System.out.print(temp[i] + " ");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		dfs(0, childs.length);
		
	}
}
