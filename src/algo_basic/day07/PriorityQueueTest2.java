package algo_basic.day07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest2 {
	private static String src = "1 2 2 1 5 7 2 5 5 5 4 7 2 4 4 4 3 1 4 6 3 2 3 2";
	
	static class Point{
		Integer i, j, v;

		public Point(int i, int j, int v) {
			super();
			this.i = i;
			this.j = j;
			this.v = v;
		}

		@Override
		public String toString() {
			return "[" + i + ", " + j + ", " + v +"]";
		}
	}
	
	public static void main(String[] args) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq = new PriorityQueue<>(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.v.equals(o2.v)) {
					return o1.i.compareTo(o2.i);
				}else {
					return o2.v.compareTo(o1.v);
				}				
			}
		});
		
		String [] splited = src.split(" ");
		for (int i = 0; i < splited.length; i+=3) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			int c = Integer.parseInt(splited[i+2]);		
			pq.add(new Point(a,b,c));
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}		
	}
}
