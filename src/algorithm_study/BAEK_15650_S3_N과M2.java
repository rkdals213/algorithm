package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_15650_S3_N과M2 {
	static int N;
	static int M;
	static int [] result;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt(); // 숫자 범위
		M = s.nextInt(); // 픽하는 개수
		result = new int [M];
		NPM(0, 1);
		
	}
	public static void NPM(int idx, int before) {
		if(idx == M) {
			print();
			return;
		}
		for (int i = before; i <= N; i++) {
			result[idx] = i;
			NPM(idx+1, i+1);
		}
	}
	public static void print() {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
