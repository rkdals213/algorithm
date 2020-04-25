package algorithm_study;


import java.util.Arrays;
import java.util.Scanner;

public class BAEK_11502_S3_세개의소수문제 {
	static int [] a = new int [3];
	public static void perm(int range) {			
		for (int i = 2; i < range; i++) {
			if(isIt(i)) {
				a[0] = i;
				for (int j = 2; j < range; j++) {
					if(isIt(j)) {
						a[1] = j;
						if(a[0] + a[1] >= range) {							
							break;
						}
						for (int j2 = 2; j2 < range; j2++) {
							if(isIt(j2)) {
								a[2] = j2;						
								if(a[0] + a[1] + a[2] == range) {	
									return;
								}else if(a[0] + a[1] + a[2] > range) {							
									break;
								}
							}
						}
					}					
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
			perm(N);
			
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

