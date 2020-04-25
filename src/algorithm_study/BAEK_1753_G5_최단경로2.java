package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_1753_G5_최단경로2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(temp.nextToken());
		int E = Integer.parseInt(temp.nextToken());
		temp = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(temp.nextToken())-1;
		
		List<Point> [] list = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			temp = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(temp.nextToken())-1;
			int t = Integer.parseInt(temp.nextToken())-1;
			int v = Integer.parseInt(temp.nextToken());
			list[s].add(new Point(t,v));
		}

		PriorityQueue<Point> pq = new PriorityQueue<>();
		Point [] D = new Point[V];
		boolean [] visited = new boolean [V];
		for (int i = 0; i < V; i++) {
			if(i == start) {
				D[i] = new Point(i,0);
			}else {
				D[i] = new Point(i,987654321);
			}
			pq.add(D[i]);
		}
		
		while(!pq.isEmpty()) {
			Point t = pq.poll();
			int target = t.target;
			int value = t.value;
			for (Point p : list[target]) {
				if(!visited[p.target] && D[p.target].value > p.value + D[target].value) {
					D[p.target].value = p.value + D[target].value;
					pq.remove(D[p.target]);
					pq.add(D[p.target]);
				}
			}
			visited[t.target] = true;
			
		}
		
		for (int i = 0; i < V; i++) {
			if(D[i].value == 987654321) System.out.println("INF");
			else System.out.println(D[i].value);
		}
		

	}
	
	static class Point implements Comparable<Point>{
		int target;
		int value;
	
		public Point(int target, int value) {
			super();
			this.target = target;
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Point [target=" + target + ", value=" + value + "]";
		}

		@Override
		public int compareTo(Point o) {
			
			return Integer.compare(this.value, o.value);
		}
	}

}
