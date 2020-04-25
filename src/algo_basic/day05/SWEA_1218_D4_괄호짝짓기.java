package algo_basic.day05;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_D4_괄호짝짓기 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for (int k = 1; k <= 10; k++) {
			boolean flag = true;
			s.nextInt();
			sb.append("#").append(k).append(" ");
			String str = s.next();
			String opener = "({<[";
			for (int i = 0; i < str.length(); i++) {
				if(opener.contains(String.valueOf(str.charAt(i)))){
					stack.push(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp != '(') {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}				
				}else if(str.charAt(i) == ']') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp != '[') {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}				
				}else if(str.charAt(i) == '}') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp != '{') {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}				
				}else if(str.charAt(i) == '>') {
					if(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp != '<') {
							flag = false;
							break;
						}
					}else {
						flag = false;
						break;
					}				
				}
			}
			if(!stack.isEmpty()) {
				flag = false;
			}
			if(!flag) {
				sb.append(0).append("\n");
			}else {
				sb.append(1).append("\n");
			}
			stack.clear();
		}
		System.out.println(sb);
	}
}
