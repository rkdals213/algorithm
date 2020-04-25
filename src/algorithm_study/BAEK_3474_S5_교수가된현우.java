package algorithm_study;
import java.io.IOException;
import java.util.Scanner;

public class BAEK_3474_S5_교수가된현우 {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		int TC = scanner.nextInt();
		int input_a;
		int mul = 0;
        
		for(int i=0; i<TC; i++) {
			mul = 0;
            input_a = scanner.nextInt();
			for(int j = 5; j <= input_a; j*=5) {
				mul += input_a/j;
			}	
			System.out.println(mul);
		}
	}
}

