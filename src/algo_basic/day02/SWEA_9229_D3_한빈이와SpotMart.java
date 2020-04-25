package algo_basic.day02;

import java.util.Scanner;

public class SWEA_9229_D3_한빈이와SpotMart {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	
		int TC = scanner.nextInt();
		for (int i = 0; i < TC; i++) {			
			int num = scanner.nextInt();
			int limit = scanner.nextInt();
			int [] weight = new int [num];
			int result = 0;
			int max = 0;
			sb.append("#").append(i+1).append(" ");
			
			for (int j = 0; j < num; j++) {
				weight[j] = scanner.nextInt();;
			}
			
			for (int j = 0; j < weight.length; j++) {
				for (int j2 = j+1; j2 < weight.length; j2++) {
					result = weight[j] + weight[j2];
					if(result <= limit && max <= result) {
						max = result;
					}
				}
			}
			if(max == 0) sb.append(-1).append("\n");
			else sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
