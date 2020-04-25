package algo_basic.day01;
import java.util.Scanner;

public class SimpleScanner {
	public static void main(String[] args) {
		// read0();
		// read1();
		// read2();
		read3();
	}
	public static void read0() { // 콘솔에서 입력받은 문자열 출력
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) { // 다음 문자열이 있을 때
			String str = scanner.next();
			System.out.println(str);
			// x or X -> break;
			if(str.equalsIgnoreCase("x")) break;			
		}
	}
	
	private static String data = "hello java world x";
	public static void read1() { // 지정된 문자열을 출력
		Scanner scanner = new Scanner(System.in);
		//scanner = new Scanner(data);
		while(scanner.hasNext()) {
			String str = scanner.next();
			System.out.println(str);
			// x or X -> break;
			if(str.equalsIgnoreCase("x")) break;			
		}
	}
	
	public static void read2() { // 지정된 문자열을 숫자로 출력
		String data= "1 2 3 4 5";
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(data);
		int sum = 0;
		while(scanner.hasNextInt()) { // 다음 정수가 있다면 / 공백을 이용해 판단
			int str = scanner.nextInt();
			System.out.println(str);
			sum += str;
			// 5 -> break;
			if(str == 5) break;			
		}
		System.out.println(sum);
	}
	
	public static void read3() { // 지정된 문자열을 숫자로 출력
		StringBuilder sb = new StringBuilder();
		String data= "1, 2, 3, 4, 5";
		Scanner scanner = new Scanner(System.in);
		scanner = new Scanner(data);
		scanner.useDelimiter(", "); // ,를 이용해 판단
		while(scanner.hasNextInt()) { // 다음 정수가 있다면 
			int str = scanner.nextInt();
			//System.out.println(str);
			sb.append(str).append("\n");
			// 5 -> break;
			if(str == 5) break;			
		}
		System.out.println(sb);
	}
}
