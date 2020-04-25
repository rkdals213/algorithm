package algo_basic.day01;

import java.util.Scanner;

public class SWEA_2056_D1_연월일달력 {
	private static int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = scanner.nextInt();
		for(int i=1; i<=TC; i++) {
			// 개별 test case 처리
			sb.append("#").append(i).append(" ");
			String data = scanner.next();
			
			String year = data.substring(0,4);
			String month = data.substring(4,6);
			String day = data.substring(6,8);
			
			if(Integer.parseInt(day) <= days[Integer.parseInt(month)]) {
				sb.append(year).append("/").append(month).append("/").append(day);
			}else {
				sb.append("-1");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
