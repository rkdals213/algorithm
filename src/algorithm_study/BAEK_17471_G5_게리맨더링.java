package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BAEK_17471_G5_게리맨더링 {
	static List<Integer>[] graph;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int [] person = new int [N];
		StringTokenizer temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(temp.nextToken());
		}
		
		graph = new List[N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();				
		}
		for (int i = 1; i <= N; i++) {
			temp = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(temp.nextToken());
			for (int j = 0; j < k; j++) {
				int end = Integer.parseInt(temp.nextToken());
				graph[i].add(end);
				graph[end].add(i);
			}
		}
		List<Set> list = new ArrayList<>();
		for (int i = 1; i < (1<<N); i++) {			
			String temp1 = Integer.toBinaryString(i);
			int count = 0;
			for (int j = 0; j < temp1.length(); j++) {
				if(temp1.charAt(j) == '1') {
					count++;
				}
			}
			if(count > N/2) {
				continue;
			}
			Set<Integer> subset = new HashSet<>();
			for (int j = 0; j < N; j++) {
				if( (i & 1<<j) > 0) { // 이러면 포함된 원소
					subset.add(j+1);
				}
			}
			list.add(subset);
		}
		//System.out.println(list.toString());
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if(solution(list.get(i))) {
				int sum1 = 0;
				int sum2 = 0;
				for (int j = 1; j <= person.length; j++) {
					if(list.get(i).contains(j)) {
						sum1 += person[j-1];
					}else {
						sum2 += person[j-1];
					}
				}
				if(Math.abs(sum1-sum2) < min) {
					min = Math.abs(sum1-sum2);
				}
//				System.out.println(sum1 + " " + sum2);
				if(min ==0) break;
			}
		}		
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
//		for (int i = 0; i < graph.length; i++) {
//			System.out.println(graph[i].toString());
//		}
	}
	static boolean solution(Set<Integer> subset) {
		boolean [] visited = new boolean [N+1];;
		for (Integer k : subset) {
//			System.out.println(subset);
//			System.out.println(k);	
			
			DFS(k, visited, 0, subset);			
			break;
		}
//		System.out.println(Arrays.toString(visited));
		for (int i = 1; i <= N; i++) {
			if(!subset.contains(i)) {
				DFS2(i, visited, 0, subset);
				break;
			}
		}
//		System.out.println(Arrays.toString(visited));
		for (int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		
		return true;
	} 
	static void DFS(int k, boolean [] visited, int count, Set<Integer> subset) {
		if(visited[k]) {
			return;
		}else {
			visited[k] = true;
			for (int i = 0; i < graph[k].size(); i++) {				
				//System.out.println(graph[k].get(i) + " " + subset.contains(graph[k].get(i)));
				if(!visited[graph[k].get(i)] && subset.contains(graph[k].get(i))) {
					DFS(graph[k].get(i), visited, 0, subset);
				}
			}
		}		
	}
	static void DFS2(int k, boolean [] visited, int count, Set<Integer> subset) {
		if(visited[k]) {
			return;
		}else {
			visited[k] = true;
			for (int i = 0; i < graph[k].size(); i++) {	
				//System.out.println(graph[k].get(i) + " " + subset.contains(graph[k].get(i)));
				if(!visited[graph[k].get(i)] && !subset.contains(graph[k].get(i))) {
					DFS2(graph[k].get(i), visited, 0, subset);
				}
			}
		}		
	}
}