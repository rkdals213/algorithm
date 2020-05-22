package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3234_D4_준환이의양팔저울 {
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int [] choo = new int [N];
			result = 0;
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(temp.nextToken());
			}
			
			DFS(N, choo, 0, 0, 0, new boolean[N]);
			
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void DFS(int N, int [] choo, int cur, int left, int right, boolean [] visited) {
		if(cur == N) {
			result++;
		}else {
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(N, choo, cur+1, left+choo[i], right, visited);
					if(right + choo[i] <= left) DFS(N, choo, cur+1, left, right+choo[i], visited);
					visited[i] = false;
				}
			}
		}
	}	
}
