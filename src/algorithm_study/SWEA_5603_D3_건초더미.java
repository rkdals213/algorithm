package algorithm_study;

import java.util.Scanner;

public class SWEA_5603_D3_건초더미 {
	static int [] input;
	
	public static int findAver() {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		return sum / input.length;
	}
	
	public static int findDiff(int aver) {
		int dif = 0;
		for (int i = 0; i < input.length; i++) {
			if(input[i] > aver) {
				dif += input[i] - aver;
			}
		}
		return dif;
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = s.nextInt();		
		
		for (int i = 0; i < TC; i++) {
			int N = s.nextInt();
			input = new int [N];
			
			for (int j = 0; j < N; j++) {			
				input[j]= s.nextInt();
			}
			sb.append("#").append(i+1).append(" ");
			
			int aver = findAver();
			int dif = findDiff(aver);	
			sb.append(dif).append("\n");
		}		
		
		System.out.println(sb);		
	}
}
