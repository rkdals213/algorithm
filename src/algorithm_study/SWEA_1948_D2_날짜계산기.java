package algorithm_study;

import java.util.Scanner;

public class SWEA_1948_D2_날짜계산기 {
	private static int [] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = s.nextInt();		
		
		for (int i = 0; i < TC; i++) {
			int SM = s.nextInt();
			int SD = s.nextInt();
			int EM = s.nextInt();
			int ED = s.nextInt();
			sb.append("#").append(i+1).append(" ");
			int sum = 0;
			
			for (int j = SM+1; j < EM; j++) {
				sum += day[j-1];
			}
			if(SM == EM) {
				sum = ED-SD+1;
			}else {
				sum += day[SM-1] - SD;
				sum += ED+1;
			}			
			sb.append(sum).append("\n");			
		}
		System.out.println(sb);
	}
}
