package algorithm_study;

import java.util.Scanner;

public class SWEA_4408_D4_자기방으로돌아가기 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = s.nextInt();
		for (int i = 0; i < TC; i++) {
			int [] room = new int [200];
			int num = s.nextInt();
			sb.append("#").append(i+1).append(" ");
			for (int j = 0; j < num; j++) {			
				int start = (s.nextInt()-1)/2;
				int end = (s.nextInt()-1)/2;
				if(start < end) {
					for (int k = start; k <= end; k++) {
						room[k]++;
					}
				} else {
					for (int k = end; k <= start; k++) {
						room[k]++;
					}
				}
							
			}
			int max = 1;
			//System.out.println(Arrays.toString(room));
			for (int j = 0; j < room.length; j++) {
				if(room[j] > max) {
					max = room[j];
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
