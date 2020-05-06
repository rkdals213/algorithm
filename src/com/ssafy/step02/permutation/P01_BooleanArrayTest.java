package com.ssafy.step02.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class P01_BooleanArrayTest {
	static int N,R;
	static int [] input,number;
	static boolean [] isSelected;
	static int totalCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		isSelected = new boolean [N];
		number = new int [R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permutation(0);
	}
	private static void permutation(int cnt) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도(앞자리까지 선택된 수 배제)
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			number[cnt] = input[i];
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
