package algo_basic.day02;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1210_D4_Ladder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	
		
		for(int k=0; k<10; k++) {	
			sb.append("#").append(k+1).append(" ");
			int input_a = scanner.nextInt();
			int [][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			sb.append(ladder(find_two(arr), arr)).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static int ladder(int a, int [][] arr) {
		int location = a;
		for(int i=99; i>=0; i--) {
			if (location < 99 && arr[i][location+1] != 0) {
				while(location < 99 && arr[i][location+1] == 1) {
					location++;				
					}				
			}
			else if (location > 0 && arr[i][location-1] != 0) {
				while(location > 0 && arr[i][location-1] == 1) {
					location--;
				}
			}			
		}
		return location;
	}
	
	public static int find_two(int [][] arr) {
		int k = 0;
		for (int i=0; i<100; i++) {
			if(arr[99][i] == 2) {
				return i;
			}
		}
		return 0;
	}
}
