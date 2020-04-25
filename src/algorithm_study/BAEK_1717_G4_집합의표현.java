package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1717_G4_집합의표현 {
	static int N,M;
	static int [] memset;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(temp.nextToken())+1;
		M = Integer.parseInt(temp.nextToken());
		memset = new int [N];
		for (int i = 0; i < N; i++) {
			memset[i] = -1;
		}
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(temp.nextToken());
			int a = Integer.parseInt(temp.nextToken());
			int b = Integer.parseInt(temp.nextToken());
			
			if(key == 0) {
				union(a,b);
			}else {
				int aroot = find(a);
				int broot = find(b);
				if(aroot == broot) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	static int find(int k) {
		if(memset[k] == -1) {
			return k;
		}else {
			return memset[k] = find(memset[k]);
		}
	}
	
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota != rootb) {
			memset[roota] = rootb;
		}
	}
}
