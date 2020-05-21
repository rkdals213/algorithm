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

public class BAEK_1062_G4_가르침 {
	static List<Character> list2;
	static Set<Character> [] list3;
	static int N,K;
	static int finalresult = 0;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(temp.nextToken());
		K = Integer.parseInt(temp.nextToken()) - 5;
		list3 = new Set[N];
		for (int i = 0; i < N; i++) {
			list3[i] = new HashSet<>();
		}
		List<Character> list = new ArrayList<>();
		list2 = new ArrayList<>();
		list.add('a');
		list.add('n');
		list.add('t');
		list.add('c');
		list.add('i');
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			for (int j = 0; j < t.length(); j++) {
				if(!list.contains(t.charAt(j)) && !list2.contains(t.charAt(j))) {
					list2.add(t.charAt(j));
				}
				if(!list.contains(t.charAt(j))) {					
					list3[i].add(t.charAt(j));
				}
				
			}			
		}		
		visited = new boolean [list2.size()];
		if(K >= 0 && K <= list2.size()) DFS(0, new char[K], 0);
		else if(K > list2.size()) finalresult = N;
		System.out.println(finalresult);
	}

	static void DFS(int cur, char [] result, int start) {
		if(cur == result.length) {
//			System.out.println(Arrays.toString(result));
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(list3[i].size() <= K) {
					Set<Character> temp = new HashSet<>();
					for (char t : list3[i]) {
						temp.add(t);
					}
					for (int j = 0; j < result.length; j++) {
						if(temp.contains(result[j])) {
							temp.remove(result[j]);
						}						
					}	
					if(temp.size() == 0) {
						count++;
					}
				}
			}
			finalresult = Math.max(count, finalresult);

			return;
		}
		for (int i = start; i < list2.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cur] = list2.get(i);
				DFS(cur+1, result, i);
				visited[i] = false;
			}
		}
	}
}