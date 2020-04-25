package algo_basic.day01;

public class Gravity {
	static int [] data = {7,4,2,0,0,6,0,7,0};
	
	public static void main(String[] args) {
		int MAX = Integer.MIN_VALUE;
		
		for(int i=0; i<data.length; i++) {
			int temp = 0;
			for(int j=i+1; j<data.length; j++) {
				if(data[i] > data[j]) {
					temp++;
				}
			}
			if (temp > MAX) {
				MAX = temp;
			}
		}
		System.out.println(MAX);
	}
}
