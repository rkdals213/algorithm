package algo_basic.day01;

public class BubbleSort {
	static int [] data = {55,7,78,12,42};
	public static void main(String[] args) {
		int temp = 0;
		for(int i=0; i<data.length; i++) {
			for(int j=i+1; j<data.length; j++) {
				if(data[i] > data[j]) {
					temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		for(int k=0; k<data.length; k++) {
			System.out.println(data[k]);
		}
	}
}
