package homework;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int bmi = b+100-a;
		System.out.println("비만수치는 "+bmi+"입니다");
		if(bmi > 0) {
			System.out.println("당신은 비만이군요");
		}

	}

}
