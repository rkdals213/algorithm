package com.ssafy.step08.DP;

import java.util.Arrays;

public class 동전거슬러주기 {
	static int [] memo;
	public static void main(String[] args) {
		// 1차원 배열에 업데이트 해서 동전 거스름돈 개수를 저장해보자
		int N = 100;
		int [] c = new int[N+1];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = i; // 1원짜리 필요한 개수
		}
		System.out.println(Arrays.toString(c));
		// 1, 4원 공전을 모두 고려
		for (int i = 4; i < c.length; i++) {
			c[i] = Math.min(c[i], c[i-4]+1);
		}
		System.out.println(Arrays.toString(c));
		// 1, 4, 6원 동전을 모두 고려
		for (int i = 6; i < c.length; i++) {
			c[i] = Math.min(c[i], c[i-6]+1);
		}
		System.out.println(Arrays.toString(c));
		
		
		N = 100;
		memo = new int[N+1];
		
		for (int i = 1; i < memo.length; i++) {
			if(i < 4) {
				memo[i] = memo[i-1]+1;
			}else if(i >= 4 && i < 6) {
				memo[i] = Math.min(memo[i-4]+1,memo[i-1]+1);
			}else {
				memo[i] = Math.min(memo[i-6]+1,memo[i-4]+1);
			}
		}
		
		System.out.println(Arrays.toString(memo));		
		for (int i = 0; i < c.length; i++) {
			if(c[i] != memo[i]) System.out.println();
		}
	}

}
