package algo_ad.day01;

import java.util.ArrayList;
import java.util.List;

public class P104_Knapsack_Full {
	static int [][] goods = {{25,10},{10,9},{10,5}};
	static int W = 30;
	public static void main(String[] args) {
		// 완전 탐색 기법으로 풀이해 보자		
		int max = 0;
		for (int i = 0; i < (1<<goods.length); i++) {
			List<Point> list = new ArrayList<>();
			int sum = 0;
			int value = 0;
			for (int j = 0; j < goods.length; j++) {
				if((i & 1<<j) > 0) {
					if(sum + goods[j][0] > W) {
						break;
					}else {
						Point p = new Point(goods[j][0], goods[j][1]);
						list.add(p);
						sum += p.x;
						value += p.y;
					}

				}
			}				
			System.out.println(list + " : " + sum + " , " + value);
			if(value > max) {
				max = value;
			}
		}
		System.out.println(max);
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
