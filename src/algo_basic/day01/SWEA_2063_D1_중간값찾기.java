package algo_basic.day01;

import java.util.Scanner;

public class SWEA_2063_D1_중간값찾기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int TC = scanner.nextInt();
		int [] array = new int[TC];
		int temp = 0;
		
		for(int i=0; i<TC; i++) {			
			array[i] = scanner.nextInt();
		}
		
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(array[TC/2]);
	}
}
