package algo_basic.day07;

import java.util.LinkedList;
import java.util.Queue;


public class Mychew {
	
	static class Point{
		Integer i, j, k;

		public Point(int i, int j, int k) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
		}

		@Override
		public String toString() {
			return i + " " + j + " " + k ;
		}
	}
	
	public static void main(String[] args) {
		Queue<Point> queue = new LinkedList<>();
		int candy = 20;
		
		Point [] a = new Point [12];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Point(0,0,i);
		}		
		
		for (int i = 0; i < 100; i++) {
			int k = i%12;
			queue.add(a[k]);
			Point temp = queue.poll();
			int x = temp.i;
			int y = temp.j;
			int z = temp.k;
			x++;
			System.out.println("현재 남은 사탕의 개수 : " + candy + " 현재 방문중인 사람 : " + z + " 그 사람의 방문 횟수 : " + x);
			if(candy - x >= 0) {
				candy -= x;
				y += x;
			}else {
				y += candy;
				candy = -1;
				a[z] = new Point(x,y,z);
				System.out.println((z+1)+ "번째 사람");
				System.out.println(a[z].i + "번 방문하여");
				System.out.println(a[z].j + "개의 사탕을 받음");
				System.out.println(queue.size() + "명의 사람이 남아있음");
				break;
			}
			
			a[z] = new Point(x,y,z);
			queue.add(a[z]);			
		}	
		for (int i = 0; i < a.length; i++) {
			System.out.println((i+1) + "번째 사람이 " + a[i].i + "번 방문하여 총 " + a[i].j + "개의 사탕을 가져감" );
		}
	}
}
