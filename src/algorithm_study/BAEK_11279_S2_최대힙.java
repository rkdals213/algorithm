package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BAEK_11279_S2_최대힙 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<myint> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(new myint(k));
			}			
		}
		System.out.println(sb);
	}
	
	static class myint implements Comparable<myint>{
		Integer x;		
		
		public myint(int x) {
			super();
			this.x = x;
		}

		@Override
		public int compareTo(myint o) {
			Integer a = this.x;
			return o.x.compareTo(a);
		}

		@Override
		public String toString() {
			return x+"";
		}		
	}
}
