package algorithm_study;

import java.util.Stack;

public class Pro_Line_CodingTest01 {

	public static void main(String[] args) {
		String inputString = "Hello, world!";
		String inputString1 = "line [plus]";
		String inputString2 = "if (Count of eggs is 4.) {Buy milk.}";
		String inputString3 = ">_<";
		
		System.out.println(solution(inputString));
		System.out.println(solution(inputString1));
		System.out.println(solution(inputString2));
		System.out.println(solution(inputString3));

	}
	
	static public int solution(String inputString) {
        int answer = 0;
        int length = inputString.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
			char key = inputString.charAt(i);
			if(key == '(' || key == '{' || key == '<' || key == '[') {
				stack.push(key);
			}else if(key == ')'){
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					answer++;
				}else {
					return -1;
				}
			}else if(key == '}'){
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
					answer++;
				}else {
					return -1;
				}
			}else if(key == '>'){
				if(!stack.isEmpty() && stack.peek() == '<') {
					stack.pop();
					answer++;
				}else {
					return -1;
				}
			}else if(key == ']'){
				if(!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
					answer++;
				}else {
					return -1;
				}
			}
		}
        
        if(stack.isEmpty()) {
        	return answer;
        }else {
        	return -1;
        }
        
        
    }

}
