package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_7206_D5_숫자게임 {
	static int[] d = new int[100000];
	static int max = -1;
	static void calculate(int value, int multiply) {
		if (d[value * multiply] != 0) {
			max = Math.max(max, d[value * multiply]);
		}

		for (int i = 10; i < value; i *= 10) {
			calculate(value / i, multiply * (value % i));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 10; i < 100000; i++) {
			max = 0;
			calculate(i, 1);
			d[i] = max + 1;
		}
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < t + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.printf("#%d %d\n", tc, d[n]);
		}
	}
}
