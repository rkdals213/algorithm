package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_17822_G3_원판돌리기 {
	static Deque<Integer>[] deque;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		int T = Integer.parseInt(temp.nextToken());
		deque = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());	
			deque[i] = new LinkedList<>();
			for (int j = 0; j < M; j++) {
				int k = Integer.parseInt(temp.nextToken());
				deque[i].add(k);
			}
			System.out.println(deque[i]);
		}
		temp = new StringTokenizer(br.readLine());			
		int x = Integer.parseInt(temp.nextToken());
		int d = Integer.parseInt(temp.nextToken());
		int k = Integer.parseInt(temp.nextToken());
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				if(j%x == 1) {
					if(d != 0) {
						for (int j2 = 0; j2 < k; j2++) {
							deque[j].add(deque[j].pollFirst());
						}
					}else {
						for (int j2 = 0; j2 < k; j2++) {
							deque[j].addFirst(deque[j].pollLast());
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.println(deque[i]);
		}
		
	}
}
