package algo_basic.day09;

import java.util.Scanner;

public class JA_1810_백설공주 {
	static int [] input = new int [9];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < input.length; i++) {
			input[i] = s.nextInt();
		}
		makeCombination(7, new int [9], 0, 0);

	}
	public static void makeCombination(int r, int [] temp, int current, int start) {
		if(current == r) {
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i];
			}
			if(sum == 100) {
				for (int i = 0; i < temp.length-2; i++) {
					System.out.println(temp[i]);
				}
			}
			
		}else {
			for (int i = start; i < input.length; i++) {
				temp[current] = input[i];
				makeCombination(r, temp, current+1, i+1);
			}
		}
	}

}
