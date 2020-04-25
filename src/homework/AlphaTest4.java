package homework;

public class AlphaTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		String [] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o"};
		
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(alpha[count] + "\t");
				count++; 
			}
			System.out.println();
		}
	}

}
