package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_11179_B1_2진수뒤집기 {
	
	public static int [] intTobin(int a) {
		int [] temp = new int [30];
		int i = 0;
		while(a>1) {
			int k = a%2;
			temp[i] = k;
			a = a/2;
			i++;
		}
		int [] result = new int [i+1];
		temp[i] = a;
		for (int j = 0; j < result.length; j++) {
			result[j] = temp[j];
		}
		return result;
	}
	public static int binToint(int [] b) {
		int result = 0;
		int temp = 0;
		for (int i = 0; i < b.length; i++) {
			temp = b[i];
			for (int j = b.length-i-1; j > 0; j--) {				
				temp *= 2;
			}
			result += temp;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int [] temp = intTobin(s.nextInt());
		System.out.println(binToint(temp));
		
	}
}
