package algo_basic.day08;

import java.util.LinkedList;
import java.util.Queue;

public class RevisitToJosephus {
	private static int n = 24;
	private static int k = 3;
	public static void main(String[] args) {
		Queue<Soldier> soldiers = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			soldiers.offer(new Soldier(i));
		}
		
		while(soldiers.size() > 2) {
			soldiers.poll();
			for (int i = 0; i < k-1; i++) {
				soldiers.offer(soldiers.poll());
			}
		}
		while(!soldiers.isEmpty()) {
			Soldier soldier = soldiers.poll();
			System.out.print(soldier.idx + " ");
		}
		
	}
	static class Soldier{
		int idx;

		public Soldier(int idx) {
			super();
			this.idx = idx;
		}			
	}
}
