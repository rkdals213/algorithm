package algorithm_study;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1966_D2_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = s.nextInt();		
		
		for (int i = 0; i < TC; i++) {		
			sb.append("#").append(i+1).append(" ");
			int N = s.nextInt();		
			ArrayList<Integer> input = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				input.add(s.nextInt());
			}
			input.sort(null);
			for (int j = 0; j < N; j++) {
				sb.append(input.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
