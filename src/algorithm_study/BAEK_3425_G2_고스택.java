package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_3425_G2_고스택 {
	static List<String> list = new ArrayList<>();
	static Stack<Long> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp;
		
		while(true) {
			int cnt = 0;
			list = new ArrayList<>();
			stack = new Stack<>();
			while(true) {				
				try {
					temp = new StringTokenizer(br.readLine());
					String input = temp.nextToken();
					if(input.equals("QUIT")) {
						System.out.println(sb);
						return;
					}
					if(input.equals("END")) {
						break;
					}else if(input.equals("NUM")) {
						list.add(input);
						list.add(temp.nextToken());
						cnt++;
					}else {
						list.add(input);
					}
					cnt++;
				} catch (NoSuchElementException e) {
					continue;
				}				
			}
			int N = Integer.parseInt(br.readLine());
			if(N==0) {
				go(cnt);
				sb.append("\n");
			}else {
				for (int i = 0; i < N; i++) {
					long a = Integer.parseInt(br.readLine());				
					stack.add(a);
					go(cnt);
					sb.append("\n");
					stack.clear();
				}
			}			
			sb.append("\n");
		}
		
	}
	static void go(int cnt) {
		for (int i = 0; i < cnt; i++) {			
			String input = list.get(i);
			if(input.equals("NUM")) {
				i++;
				long x = Integer.parseInt(list.get(i));
				stack.add(x);
			}else if(input.equals("POP")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("INV")) {
				if(!stack.isEmpty()) {
					long t = stack.pop();
					stack.add(t*(-1));
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("DUP")) {
				if(!stack.isEmpty()) {
					long t = stack.pop();
					stack.add(t);
					stack.add(t);
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("SWP")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();					
					stack.add(a);
					stack.add(b);
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("ADD")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();
					if(Math.abs(a+b) > 1000000000) {
						sb.append("ERROR");
						return;
					}
					stack.add(a+b);
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("SUB")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();
					if(Math.abs(b-a) > 1000000000) {
						sb.append("ERROR");
						return;
					}
					stack.add(b-a);
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("MUL")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();
					if(Math.abs(a*b) > 1000000000) {
						sb.append("ERROR");
						return;
					}
					stack.add(b*a);
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("DIV")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();
					int k = 0;
					if(a < 0) {
						a=Math.abs(a);
						k++;
					}
					if(b < 0) {
						b=Math.abs(b);
						k++;
					}
					if(a==0) {
						sb.append("ERROR");
						return;
					}
					long result = b/a;
					if(k==1) {
						stack.add(result*(-1));
					}else {
						stack.add(result);
					}
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("MOD")) {
				if(stack.size()>1) {
					long a = stack.pop();
					long b = stack.pop();
					int k = 0;
					if(a < 0) {
						a=Math.abs(a);
						
					}
					if(b < 0) {
						b=Math.abs(b);
						k++;
					}
					if(a==0) {
						sb.append("ERROR");
						return;
					}
					long result = b%a;					
					if(k==1) {
						stack.add(result*(-1));
					}else {
						stack.add(result);
					}
				}else {
					sb.append("ERROR");
					return;
				}
			}else if(input.equals("END")){
				break;
			}
				
		}
		if(stack.isEmpty() || stack.size() > 1) {
			sb.append("ERROR");
		}else {
			sb.append(stack.pop());
		}
	}

}