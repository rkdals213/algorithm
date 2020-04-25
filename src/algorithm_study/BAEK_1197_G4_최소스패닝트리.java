package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BAEK_1197_G4_최소스패닝트리 {
	static int [] root;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(temp.nextToken());
		int E = Integer.parseInt(temp.nextToken());
		
		root = new int [V];
		for (int i = 0; i < V; i++) {
			root[i] = -1;
		}
		int [][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			temp = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(temp.nextToken())-1;
			edges[i][1] = Integer.parseInt(temp.nextToken())-1;
			edges[i][2] = Integer.parseInt(temp.nextToken());
		}
		
		Arrays.sort(edges, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				Integer a = o1[2];
				Integer b = o2[2];
				return a.compareTo(b);
			}
		});
		
		for (int i = 0; i < E; i++) {
			if(union(edges[i][0],edges[i][1])) {
				result += edges[i][2];
			}
		}
		System.out.println(result);
	}
	
	static int find(int x) {
		if(root[x] == -1) return x;
		else return root[x] = find(root[x]);
	}
	
	static boolean union(int x, int y) {
		int rootx = find(x);
		int rooty = find(y);
		
		if(rootx != rooty) {
			root[rootx] = rooty;
			return true;
		}
		return false;
	}

}
