package algorithm_study;

import java.util.Scanner;

public class BAEK_1566_S1_P배열 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		//int TC = scanner.nextInt();
		int input_a = scanner.nextInt();
		int input_b = scanner.nextInt();		
		
		int [][] data = new int[input_a][input_b];
		
		
		int count = 0;
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j] = scanner.nextInt();;
			}
		}
		while(true) {
			int min = 0;
			int [] sum_col = new int[input_a];
			int [] sum_raw = new int[input_b];
			int [] mini = new int [2];
			
			for(int i=0; i<data.length; i++) {
				for(int j=0; j<data[i].length; j++) {
					sum_col[i] += data[i][j];
					sum_raw[i] += data[j][i];
				}
			}
						
			for(int i=0; i<sum_col.length; i++) {
				if(sum_col[i] < min) {
					min = sum_col[i];
					mini[0] = 0;
					mini[1] = i;
				}
			}
			for(int i=0; i<sum_raw.length; i++) {
				if(sum_raw[i] < min) {
					min = sum_raw[i];
					mini[0] = 1;
					mini[1] = i;
				}
			}
			//System.out.println(min);
			if (min >= 0) {
				System.out.println(count);
				break;
			}
			else if(count > 100) {
				System.out.println("-1");
				break;
			}
			
			if(mini[0] == 0) {
				for(int i=0; i<sum_raw.length; i++) {
					data[mini[1]][i] *= -1;
				}
			}
			else {
				for(int i=0; i<sum_raw.length; i++) {
					data[i][mini[1]] *= -1;
				}
			}/*
			for(int i=0; i<data.length; i++) {
				for(int j=0; j<data[i].length; j++) {
					System.out.print(data[i][j] + " ");
				}
				System.out.println();
			}
			for(int i=0; i<data.length; i++) {
				System.out.print(sum_col[i] + " ");
				System.out.print(sum_raw[i] + " ");
			}
			System.out.println();
			System.out.println("---------------------------------");*/
			count++;
		}
	}
}