package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_14501_S4_퇴사 {
	static Point [] point; 
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		point = new Point[N];
		
		
		
		for (int i = 0; i < N; i++) {
			point[i] =  new Point(s.nextInt(), s.nextInt());
		}
		makeCombination(N, new int [N], 0, 0);
		System.out.println(max);
		
	}
	public static void makeCombination(int r, int [] temp, int current, int start) {
		if(current >= r) {
			//System.out.println(Arrays.toString(temp));
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				if(temp[i] == 1) {
					sum+=point[i].money;
				}
			}
			if(sum > max) {
				max = sum;
			}
		}else {
			for (int i = start; i < r; i++) {				
				int k = point[i].day;
				if(i+k > r) {
					//System.out.println(Arrays.toString(temp));
					int sum = 0;
					for (int j = 0; j < temp.length; j++) {
						if(temp[j] == 1) {
							sum+=point[j].money;
						}
					}
					if(sum > max) {
						max = sum;
					}
					continue;
				}
				temp[i] = 1;
				makeCombination(r, temp, i+k, i+k);
				temp[i] = 0;
			}
		}
	}	
	
	static class Point{
		int day;
		int money;
		
		public Point(int day, int money) {
			super();
			this.day = day;
			this.money = money;
		}

		@Override
		public String toString() {
			return "Point [day=" + day + ", money=" + money + "]";
		}	
		
	}
}
