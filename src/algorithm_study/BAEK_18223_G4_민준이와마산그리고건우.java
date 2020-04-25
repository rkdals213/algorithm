package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_18223_G4_민준이와마산그리고건우 {
	static final String t = "SAVE HIM";
	static final String f = "GOOD BYE";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Point> pq1 = new PriorityQueue<>();
		PriorityQueue<Point> pq2 = new PriorityQueue<>();
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(temp.nextToken());
		int E = Integer.parseInt(temp.nextToken());	
		int P = Integer.parseInt(temp.nextToken())-1;	
		
		List<Point> [] gr = new ArrayList [V];
		
		for (int i = 0; i < V; i++) {
			gr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			temp = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(temp.nextToken())-1;
			int b = Integer.parseInt(temp.nextToken())-1;
			int c = Integer.parseInt(temp.nextToken());
			gr[a].add(new Point(b,c));
			gr[b].add(new Point(a,c));
		}
		
		Point [] D1 = new Point [V];
		Point [] D2 = new Point [V];
		for (int i = 0; i < V; i++) {
			if(i==0) {
				D1[i] = new Point(i, 0);
				D2[i] = new Point(i, 987654321);
			}
			else if(i==P) {
				D1[i] = new Point(i, 987654321);
				D2[i] = new Point(i, 0);
			}else {
				D1[i] = new Point(i, 987654321);
				D2[i] = new Point(i, 987654321);
			}			
			
			if(P==0) {
				D2[i] = new Point(i,0);
			}
			pq1.add(D1[i]);
			pq2.add(D2[i]);
		}
				
		while(!pq1.isEmpty()) {
			Point t = pq1.poll();
			for (Point p : gr[t.next]) {
				if(D1[p.next].weight > D1[t.next].weight + p.weight) {
					D1[p.next].weight = D1[t.next].weight + p.weight;
					pq1.remove(D1[p.next]);
					pq1.add(D1[p.next]);
				}
			}			
		}
		
		while(!pq2.isEmpty()) {
			Point t = pq2.poll();
			for (Point p : gr[t.next]) {
				if(D2[p.next].weight > D2[t.next].weight + p.weight) {
					D2[p.next].weight = D2[t.next].weight + p.weight;
					pq2.remove(D2[p.next]);
					pq2.add(D2[p.next]);
				}
			}			
		}
		
		if(D1[V-1].weight == D1[P].weight + D2[V-1].weight) System.out.println(t);
		else System.out.println(f);

	}
	
	static class Point implements Comparable<Point>{
		int next;
		int weight;
		@Override
		public String toString() {
			return "Point [next=" + next + ", weight=" + weight + "]";
		}
		public Point(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
