package algo_basic.day05;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_D3_제로 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		int TC = s.nextInt();
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			int length = s.nextInt();
			int sum = 0;
			Stack<Integer> stack = new Stack<>();
			for (int j = 0; j < length; j++) {
				int temp = s.nextInt();
				if(temp == 0) {
					stack.pop();					
				}else {
					stack.push(temp);
				}
			}
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}			
			sb.append(sum).append("\n");			
		}
		System.out.println(sb);

	}

}
