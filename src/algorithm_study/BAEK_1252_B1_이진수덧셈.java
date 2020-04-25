package algorithm_study;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_1252_B1_이진수덧셈 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		String a = scanner.next();
		String b = scanner.next();
		int [] aa = new int [81];
		int [] bb = new int [81];
		for (int i = 0; i < a.length(); i++) {
			aa[i] = a.charAt(a.length() - i - 1)-'0';
		}
		for (int i = 0; i < b.length(); i++) {
			bb[i] = b.charAt(b.length() - i - 1)-'0';
		}
		int [] temp = new int [81]; 
		int temp1 = 0;
		for (int i = 0; i < 81; i++) {
			temp[i] = aa[i] + bb[i] + temp1;
			if(temp[i] > 1) {
				temp[i] = temp[i]%2;
				temp1 = 1;
			}else {
				temp1 = 0;
			}
		}
		boolean flag = false;
		for (int i = temp.length - 1; i >= 0 ; i--) {
			if(temp[i] == 1) {
				for (int j = i; j >= 0; j--) {
					flag = true;
					sb.append(temp[j]);
				}
				break;
			}
		}	
		if(flag)System.out.println(sb);
		else System.out.println(0);
		
	}
}
