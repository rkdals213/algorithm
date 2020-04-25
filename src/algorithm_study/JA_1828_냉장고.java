package algorithm_study;

import java.util.Scanner;

public class JA_1828_냉장고 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		int [] room = new int [10270+1];
		int num = s.nextInt();
		for (int j = 0; j < num; j++) {			
			int start = s.nextInt();
			int end = s.nextInt();
			
			for (int k = start+270; k <= end+270; k++) {
				room[k]++;
			}						
		}
		int max = 1;
		//System.out.println(Arrays.toString(room));
		for (int j = 0; j < room.length; j++) {
			if(room[j] > max) {
				max = room[j];
			}
		}
		System.out.println(num - max + 1);	
	}
	
	static class Point{
		int a;

		public Point(int a) {
			super();
			this.a = a;
		}
		
	}
}
