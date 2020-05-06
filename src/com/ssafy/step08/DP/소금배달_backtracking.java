package com.ssafy.step08.DP;

import java.util.Scanner;

public class 소금배달_backtracking {
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		gogosing(M, 0);
//		System.out.println(min == Integer.MAX_VALUE? -1 : min);
		
	}
	static void gogosing(int M, int cnt) { // M 남은 무게, cnt 봉지개수
		if(M < 0) { // 해가 없다
			return;
		}else if(M == 0){
			if(min > cnt) {
				min = cnt;
			}
			System.out.println(min == Integer.MAX_VALUE? -1 : min);
			System.exit(0);
		}
		else {
			gogosing(M-5, cnt+1);
			gogosing(M-3, cnt+1);
		}
	}

}
