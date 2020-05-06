package com.ssafy.step08.DP;

import java.util.Scanner;

public class 소금배달_greedy {

	public static void main(String[] args) {
		// 3kg 5kg
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
//		int cnt = (M/5) + ((M%5) / 3); // 가설이 틀림
		int cnt = 0;
		// 21kg -> 5 5 5 5 3 X -> 5 5 5 3 3 O
		// 18kg 3
		// 15kg 3 3 -> 5 5 5
		// 4kg x
		// 1kg 3
		// -2 3 3
		// -5 3 3 3
		
		while(M%5 != 0) {
			M-=3;
			cnt++;
		}
		
		if(M < 0) {
			cnt = -1;
		}else {
			cnt += M/5;	
		}
		
		System.out.println(cnt);
		
		
	}

}
