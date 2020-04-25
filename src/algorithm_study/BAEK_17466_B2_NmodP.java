package algorithm_study;

import java.util.Scanner;

public class BAEK_17466_B2_NmodP {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long N = s.nextInt();
		long P = s.nextInt();
		long result = 1;
		for (int i = (int) N; i > 1; i--) {
			result = (result*i)%P;
		}
		System.out.println(result);
	}
}
