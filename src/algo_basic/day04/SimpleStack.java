package algo_basic.day04;

import java.util.Stack;

public class SimpleStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		System.out.println(stack.size());
		int top = stack.peek(); // 확인
		System.out.println(top);
		System.out.println(stack.size());
		top = stack.pop(); // 뺀다
		System.out.println(top);
		System.out.println(stack.size());

	}

}
