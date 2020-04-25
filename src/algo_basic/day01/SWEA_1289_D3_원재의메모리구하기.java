package algo_basic.day01;

import java.util.Scanner;

public class SWEA_1289_D3_원재의메모리구하기 {	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		int TC = scanner.nextInt();
		
		for(int i=1; i<=TC; i++) {
			sb.append("#").append(i).append(" ");
			String data = scanner.next();				
			char[] data_array = data.toCharArray();
			int count = 0;
			if (data_array[0] == '1') count++;
			for(int j = 1; j<data_array.length; j++) {
				if(data_array[j] != data_array[j-1]) {
					count++;
				}
			}
			sb.append(count).append("\n");	
		}
		System.out.println(sb);
	}	
}
