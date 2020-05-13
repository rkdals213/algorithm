package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2252_G2_줄세우기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		List<Integer> [] gr = new List [N+1];
		for (int i = 0; i < N+1; i++) {
			gr[i] = new ArrayList<>();
		}
		int [] depth = new int [N+1];
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(temp.nextToken());
			int B = Integer.parseInt(temp.nextToken());
			gr[A].add(B);
			depth[B] += 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i < depth.length; i++) {
			if(depth[i] == 0) q.add(i);			
		}
		while(!q.isEmpty()) {
			int k = q.poll();
			sb.append(k).append(" ");
			for (int i = 0; i < gr[k].size(); i++) {
				depth[gr[k].get(i)] -= 1;
				if(depth[gr[k].get(i)] == 0) q.add(gr[k].get(i));
			}
		}
		System.out.println(sb);
	}
}
