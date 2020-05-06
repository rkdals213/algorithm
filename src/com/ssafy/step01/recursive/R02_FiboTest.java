package com.ssafy.step01.recursive;

import java.util.Scanner;

public class R02_FiboTest {

	private static long fibo(int n) {
		if(n<=1) return n;
		return fibo(n-1) + fibo(n-2);
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));

	}

}
