package algorithm_study;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1234_D3_비밀번호 {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = 10;
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			int N = s.nextInt();
			String input = s.next();
			ArrayList<Character> list = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				list.add(input.charAt(j));
			}
	
			int index = 0;
			int size = list.size();
			while(index < size - 1) {
				if(list.get(index) == list.get(index+1)) {
					list.remove(index);
					list.remove(index);
					size = list.size();
					index = 0;
				}
				else {
					index++;
				}
			}
			for (int j = 0; j < list.size(); j++) {
				sb.append(list.get(j));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
