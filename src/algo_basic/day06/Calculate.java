package algo_basic.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculate {
	private static String src = "(2+((3*4)/5))";
	public static void main(String[] args) {
		System.out.println(getPostfixNotation());
		System.out.println(calPostfixNotation(getPostfixNotation()));		
	}
	
	private static List<Character> getPostfixNotation(){
		List<Character> postfixNotation = new ArrayList<>();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < src.length(); i++) {
			// 데이터와 그 우선순위를 확인
			char c = src.charAt(i);
			int order = getOrder(c);			
			if(order == 0) {
				postfixNotation.add(c); // 숫자는 그냥 출력한다
			}else if(order == 2) { 
				stack.push(c);  // 여는 괄호는 무조건  push
			}else if(order == 1) { // 닫는 괄호 : 여는괄호를 만날때까지 pop --> add
				while(true) {
					char top = stack.pop();
					if(top == '(') {
						break;
					}else {
						postfixNotation.add(top);
					}
				}
			}else { // 일반적인 연산자가 왔다면
				while(true) {
					if(stack.isEmpty()) break;
					char top = stack.peek();
					if(getOrder(top) >= order) {
						postfixNotation.add(stack.pop());
					}else {
						break;
					}
				}
				//  원탑의 조건이 완성되었으므로 내가 들어간다
				stack.push(c);
			}
			// 아직 남아있는 녀석들이 있다면 소진시키기			
		}
		while(!stack.isEmpty()) {
			postfixNotation.add(stack.pop());
		}		
		return postfixNotation;		
	}
	
	public static int calPostfixNotation(List<Character> input) {
		// 피연산자를 담아놓을  stack
		Stack<Integer> stack = new Stack<>();
		for (Character c : input) {
			if(getOrder(c) == 0) {
				stack.push(c-'0');
			}else {
				Integer num2 = stack.pop();
				Integer num1 = stack.pop();				
				if(c == '+') {
					stack.push(num1+num2);
				}else if(c == '-') {
					stack.push(num1-num2);
				}else if(c == '*') {
					stack.push(num1*num2);
				}else if(c == '/') {
					stack.push(num1/num2);
				}
			}
		}
		return stack.pop();		
	}
	
	public static int getOrder(char c) {
		if(c=='*' || c=='/'){
			return 4;
		}else if(c=='+' || c=='-') {
			return 3;
		}else if(c=='(') {
			return 2;
		}else if(c==')') {
			return 1;
		}else {
			return 0;
		}
	}
}
