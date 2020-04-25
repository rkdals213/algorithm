package algo_basic.day01;

import java.util.Scanner;

public class test {
	public static int MAX(int a, int b) {
		return a>b ? a:b;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();		
		int TC = scanner.nextInt();
		
		for(int i=1; i<=TC; i++) {
			sb.append("#").append(i).append(" ");
			
			int souce = scanner.nextInt();
			int cal = scanner.nextInt();
			
			int [] score_array = new int [souce];
			int [] cal_array = new int [souce];
			
			for(int j=0; j<souce; j++) {				
				String data_score = scanner.next();
				String data_cal = scanner.next();	
				score_array[j] = Integer.parseInt(data_score);
				cal_array[j] = Integer.parseInt(data_cal);				
			}			
			
			int [][] dp = new int [souce+1][cal+1];
			for(int a = 0; a<dp.length; a++) {
				for(int b = 0; b<dp[a].length; b++) {
					dp[a][b] = 0;	
				}
			}
			for(int a = 1; a<=souce; a++) {
				for(int b = 1; b<=cal; b++) {
					if(cal_array[a-1] > b) {
						dp[a][b] = dp[a-1][b];
					}
					else {
						dp[a][b] = MAX(dp[a-1][b], dp[a-1][b-cal_array[a-1]] + score_array[a-1]);
					}
				}
			}
			sb.append(dp[souce][cal]).append("\n");
		}
		
		System.out.println(sb);
	}
}
