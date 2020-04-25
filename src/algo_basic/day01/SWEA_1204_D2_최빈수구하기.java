package algo_basic.day01;

import java.util.Scanner;

public class SWEA_1204_D2_최빈수구하기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		int TC = scanner.nextInt();
		
		for(int i=1; i<=TC; i++) {
			int max = Integer.MIN_VALUE;
			int max_num = 0;

			int data = 0;
			int [] count = new int[101];
			
			StringBuilder sb = new StringBuilder();	
			sb.append("#").append(i).append(" ");
			int test_case = scanner.nextInt();
			
			for (int j=0; j<1000; j++) {
				data = scanner.nextInt();
				count[data]++;
			}
			
			for (int k=0; k<101; k++) {
				if(max <= count[k]) {
					max = count[k];
					max_num = k;
				}
			}
			
			System.out.println();
			sb.append(max_num);
			System.out.println(sb);
			
		}
	}

}
