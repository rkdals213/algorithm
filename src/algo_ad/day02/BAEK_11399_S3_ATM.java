package algo_ad.day02;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_11399_S3_ATM {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int [] person = new int[N];
		for (int i = 0; i < person.length; i++) {
			person[i] = s.nextInt();
		}
		Arrays.sort(person);
		int sum = 0;
		for (int i = 0; i < person.length; i++) {
			for (int j = 0; j <= i; j++) {
				sum += person[j];
			}
		}
		System.out.println(sum);
	}
}
