package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BAEK_4195_G2_친구네트워크 {
	static int N;
	static int [] root, depth;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int i = 0; i < TC; i++) {			
			root = new int[100001];
			depth = new int[100001];
			
			for (int j = 0; j < 100001; j++) {
				root[j] = j;
				depth[j] = 1;
			}
			int cnt = 1;
			
			HashMap<String, Integer> name = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			for (int j = 0; j < N; j++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				String a = temp.nextToken();
				String b = temp.nextToken();
				
				if(!name.containsKey(a)) name.put(a, cnt++);
				if(!name.containsKey(b)) name.put(b, cnt++);
				
				int idx1 = name.get(a);
				int idx2 = name.get(b);
				
				int root1 = find(idx1);
				int root2 = find(idx2);
				
				union(root1, root2);
			}

		}
		System.out.println(sb);

	}
	
	static int find(int n) {
		if(root[n] == n) return n;
		return root[n] = find(root[n]);
	}
	
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		
		if(roota != rootb) {
			root[rootb] = roota;
			depth[roota] += depth[rootb];
		}
		sb.append(depth[roota] + "\n");
	}

}
