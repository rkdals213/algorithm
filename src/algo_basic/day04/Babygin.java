package algo_basic.day04;

import java.util.Arrays;

public class Babygin {
	static int [] flag;
	static int result;
	public static void main(String[] args) {
		String [] data = {"667767", "054060", "101123", "235777", "781239"};
		for (int i = 0; i < data.length; i++) {
			flag = new int [10];
			result = 0;
			
			for (int j = 0; j < data[i].length(); j++) {
				flag[(int)(data[i].charAt(j)-'0')]++;
			}
			findrun();
			findtriplet();
			if(result == 2) {
				System.out.println(i + "번째는 triplet");
			}else {
				System.out.println(i + "번째는 실패");
			}
		}
	}
	public static void findtriplet() {
		for (int i = 0; i < flag.length; i++) {
			if(flag[i] >= 3) {
				flag[i] -= 3;
				result++;
			}
		}
	}
	public static void findrun() {		
		for (int j = 0; j < flag.length-2; j++) {
			if(flag[j] >= 1 && flag[j+1] >= 1 && flag[j+2] >= 1) {
				flag[j] -= 1;
				flag[j+1] -= 1;
				flag[j+2] -= 1;
				result++;
			}
		}
	}	
}
