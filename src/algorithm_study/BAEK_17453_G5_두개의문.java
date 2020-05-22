package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_17453_G5_두개의문 {
	static int [] input;
	static int [][] button;
	static int N,M;
	static List<Integer> [] yearResult;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());

		input = new int [N];
		String t = br.readLine();
		for (int i = 0; i < N; i++) {
			if(t.charAt(i) == '1')	input[i] = 1;
			else input[i] = -1;
		}
		button = new int [M][N];
		for (int i = 0; i < M; i++) {
			t = br.readLine();
			for (int j = 0; j < N; j++) {
				if(t.charAt(j) == '0')	button[i][j] = 1;
				else button[i][j] = -1;
			}
		}
		visited = new boolean [2*N+1];
		yearResult = new List [2*N+1];
		for (int i = 0; i < yearResult.length; i++) {
			yearResult[i] = new ArrayList<>();
		}

		for (int i = 0; i < (1<<M); i++) {
			List<Integer> subset = new ArrayList<>();
			for (int j = 0; j < M; j++) {
				if( (i & 1<<j) > 0) { // 이러면 포함된 원소
					subset.add(j);
				}
			}
			go(subset);
		}
		for (int i = 0; i < yearResult.length; i++) {
			if(!visited[i]) {
				System.out.println(-1);
			}else {
				System.out.print(yearResult[i].size() + " ");
				for (int j = 0; j < yearResult[i].size(); j++) {
					System.out.print(yearResult[i].get(j) + " ");
				}
				System.out.println();
			}			
		}
	}

	static void go(List<Integer> subset) {
		int [] temp = new int [N]; 
		temp = input.clone();
		for (int i = 0; i < subset.size(); i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[j] *= button[subset.get(i)][j];
			}
		}
		int result = 0;
		for (int i = 0; i < temp.length; i++) {
			result += temp[i];
		}
		if(!visited[result+N]) {
			for (int i = 0; i < subset.size(); i++) {
				yearResult[result+N].add(subset.get(i)+1);
			}
			visited[result+N] = true;

		}

	}
}