package algo_basic.day03;

import java.util.Scanner;

/**
 * 
 * @author 강민형
 * @since 2020. 1. 29.
 * @see
 * @mem
 * @time
 * @caution
 *
 */

public class JA_1175_주사위던지기2 {
	static int [] dices;
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 주사위 개수
		M = scanner.nextInt(); // 주사위의 합
		dices = new int [N]; // 출력 방식
		game1(0);
	}
	public static void print() {
		for(int d:dices) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	public static void game1(int idx) {
		if(idx == N) {
			int sum=0;
			for (int i = 0; i < dices.length; i++) {
				sum+=dices[i];
			}
			if(sum == M)print();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			dices[idx] = i;
			game1(idx+1);
		}
	}

}
