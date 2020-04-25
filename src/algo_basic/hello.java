package algo_basic;

public class hello {
	public static void main(String[] args) {
		int [][] arr = new int [4][4];
		int count = 0;
		for (int k = 0; k < 4; k++) {
			for (int k2 = 0; k2 < 4; k2++) {
				arr[k][k2] = count;
				count++;
			}
		}
		String [][] Array = new String [5][5];
		System.out.println();
		for (int k = 0; k < 5; k++) {
			for (int k2 = 0; k2 < 5; k2++) {
				System.out.println(Array[k][k2]);
			}
		}
	}
}
