package algo_basic.day07;

public class BacktrackPowersetSum {
static int [] childs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 사용가능한 종류는?
	
	static int [] subset = new int[childs.length]; 
	static boolean [] visited = new boolean[childs.length];
	static int [] temp = new int[childs.length]; 
	
	public static void dfs(int k, int input) {
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum+= temp[i];
		}		
		
		if(sum == 10) {
			printSolution();
		}
		
		// 탐색 - 다음 자식으로.				
		for (int i = 0; i < childs.length; i++) {
			if(sum+childs[i] > 10) {
				k = input;
				break;
			}
			if(!visited[i]) {
				visited[i] = true;
				temp[k]=childs[i];
				dfs(k+1, input);
				temp[k] = 0;
				visited[i] = false;
			}
		}		
	}
	
	private static void printSolution() {
		for (int i = 0; i < temp.length; i++) {
			if(temp[i]!=0) System.out.print(temp[i] + " ");					
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		dfs(0, 3);
		
	}

}
