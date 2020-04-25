package algo_basic.day01;

import java.util.Scanner;

public class SplitTest {
	public static void split1() {
		String src = "10,030,042";
		src = "10.030.042";
		String [] splited = src.split("\\.");
		int sum = 0;
		for(int i = 0; i < splited.length; i++) {
			sum += Integer.parseInt(splited[i]);
		}
		System.out.println(sum);
	}
	
	public static void split2() {
		String src = "이름:홍길동,Java:100,HTML:80,Script:85";
		String [] splited = src.split(",|:");
		int sum = 0;
		for(int i = 3; i < splited.length; i+=2) {
			sum += Integer.parseInt(splited[i]);
		}
		System.out.println(splited[1] + " : " + sum);
		System.out.printf("%s : %d\n", splited[1], sum);
	}
	
	public static void split3() {
		
	}

	public static void main(String[] args) {
		
		//split1();
		split2();
	}

}
