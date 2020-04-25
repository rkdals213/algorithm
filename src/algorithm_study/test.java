package algorithm_study;


import java.util.Arrays;
import java.util.Scanner;

public class test {
	static int [] a = new int [3];
	public static void perm(int [] result, int count, int range, int depth) {
		if(count == depth) {
			int sum = 0;
			int i = 0;
			while(i < depth) {				
				sum+= result[i];
				i++;
			}
			
			if(i == depth && sum == range) {				
				a[0] = result[0];
				a[1] = result[1];
				a[2] = result[2];				
			}
		}else {
			for (int i = 2; i < range; i++) {
				if(isIt(result[i])) {
					result[count] = i;					
					perm(result, count+1, range, depth);
				}				
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int TC = s.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			int N = s.nextInt();
			int [] result = new int [N];
			perm(result, 0, N, 3);
			Arrays.sort(a);
			
			for (int j = 0; j < a.length; j++) {
				sb.append(a[j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isIt(int input) {		
		for (int i = 2; i < input; i++) {
			if(input % i == 0) {
				return false;
			}
		}
		return true;		
	}
}
