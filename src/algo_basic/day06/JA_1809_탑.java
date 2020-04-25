package algo_basic.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JA_1809_탑 {
	
	static class Point{
		int i, v;

		public Point(int i, int v) {
			super();
			this.i = i;
			this.v = v;
		}

		@Override
		public String toString() {
			return v + " ";
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Point> stack = new Stack<>();	

		int N = Integer.parseInt(s.readLine());
		int [] result = new int [N];		
		StringTokenizer a = new StringTokenizer(s.readLine());
		
		int top = Integer.parseInt(a.nextToken());
		stack.push(new Point(0, top));
		int i=1;
		
		while(i < N) {
			top = Integer.parseInt(a.nextToken());
			while(!stack.isEmpty() && i < N) {
				Point topv = stack.peek();
				if(topv.v < top) {
					stack.pop();
				}
				else {
					stack.push(new Point(i, top));
					result[i] = topv.i+1;
					i++;
					break;
				}
				if(stack.isEmpty()) {
					stack.push(new Point(i, top));
					i++;
					break;
				}
			}	
		}
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j] + " ");
		}
	}
}
