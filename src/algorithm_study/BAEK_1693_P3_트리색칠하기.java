package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_1693_P3_트리색칠하기 {
	static int N;
	static List<Integer> [] tree;
	static int [][] DP;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(br.readLine());
		tree = new List [N+1];
		visited = new boolean [N+1];
		DP = new int [N+1][(int) Math.log(N)];
		
		for (int i = 0; i <= tree.length; i++) {
			tree[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {			
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());
			tree[a].add(b);
		}
		for (int i = 0; i < tree.length; i++) {
			System.out.println(tree[i].toString());
		}
		
		
		
		
	}

}
