package algo_basic.day05;

import java.util.Stack;

public class StackCheck {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		String str = "@==(^O^)@@(^O^)==@@==(^O^)@@(^O^)==@";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '('){
				stack.push('(');
			}else if(str.charAt(i) == ')') {
				if(!stack.isEmpty()) {
					stack.pop();
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
			System.out.println("false");
		}else {
			System.out.println("true");
		}
	}
}
