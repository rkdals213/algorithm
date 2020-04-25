package monthlyTest01;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String ch=s.next();
		if(ch.equals("1")) {
			int count = 1;
			for (int i = 1; i <= 4; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(count);
					count++;
				}
				System.out.println();
			}
		}
		
		else if(ch.equals("A")) {
			char count = 'A';
			for (int i = 0; i < 6; i++) {
				for (int j = 9/2 - i + 1; j > 0 ; j--) {
					System.out.print(" ");
				}
				for (int j = 9/2 - i; j < 9/2 + i-1; j++) {
					System.out.print(count);
					count++;
				}
				System.out.println();
				
			}
		}	
		
		
	}

}
