package algo_basic.day07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer len1 = o1.length();
				Integer len2 = o2.length();
				if(len1.equals(len2)) {
					return o2.compareTo(o1);
				}
				return len2.compareTo(len1);
			}
		});
		pq.offer("true");
		pq.offer("dream");
		pq.offer("is");
		pq.offer("come");

		while(!pq.isEmpty()) {
			System.out.println(pq.remove());			
		}	
	}
}
