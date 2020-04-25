package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1976_G4_여행가자 {
	static int N; // 도시의 수 <= 200
	static int M; // 여행계획에 속한 도시들의 수
	static int [][] map;
	static int [] root;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		root = new int [N];
		map = new int [N][N];		
		StringTokenizer temp;
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			root[i] = -1;
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					union(i,j);
				}
			}
		}
		
		boolean flag = true;
		temp = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(temp.nextToken())-1;
		int startnode = find(start);
		for (int i = 0; i < M-1; i++) {
			int node = Integer.parseInt(temp.nextToken())-1;
			if(startnode != find(node)) {
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}		
		
	}
	
	static int find(int n) {
		if(root[n] == -1)return n;
		return root[n] = find(root[n]);
	}
	
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		
		if(roota != rootb) {
			root[rootb] = roota;
		}
	}
}
