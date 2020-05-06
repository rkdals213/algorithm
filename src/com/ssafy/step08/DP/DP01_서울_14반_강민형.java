package com.ssafy.step08.DP;

import java.util.Arrays;

public class DP01_서울_14반_강민형 {
	/*
	 * 1cm 파란막대, 2cm 노란막대, 3cm 빨간막대
	 * 길이가 n인 막대를 만드는 방법의 수
	 */
	
	static int [] memo;
	public static void main(String[] args) {
		int N = 10;
		memo = new int[N+1];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		DP(N);
		System.out.println(Arrays.toString(memo));
	}
	
	static int DP(int n) {
		if(n < 3) {
			return memo[n];
		}else if(memo[n] > 0){
			return memo[n];
		}else {
			return memo[n] = DP(n-1) + DP(n-2) + DP(n-3);
		}
	}
}
