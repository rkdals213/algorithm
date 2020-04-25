package algo_basic.day02;

import java.util.Scanner;

public class SWEA_5356_D3_의석이의세로로말해요 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);        
		StringBuilder sb = new StringBuilder();
		
		int TC = scanner.nextInt();
		
		for (int i = 0; i < TC; i++) {
			String [][] Array = new String [5][15];
			sb.append("#").append(i+1).append(" ");
			for (int j = 0; j < 5; j++) {
				String str = scanner.next();
				for (int k = 0; k < str.length(); k++) {
					Array[j][k] = str.substring(k, k+1);
				}
			}
			for (int j = 0; j < 15; j++) {
				for (int k = 0; k < 5; k++) {
					if(Array[k][j] != null) {
						sb.append(Array[k][j]);
					}
				}
			}
			sb.append("\n");			
		}
		System.out.println(sb);
	}

}
