package algo_basic.day02;

public class Counting_Sort {
	static int [] data = {0,4,1,3,1,2,4,1};
	public static void main(String[] args) {
			int [] count = new int [5];
			int [] counts = new int [5];
			int [] result = new int [8];
			
			for(int i=0; i<data.length; i++) {
				count[data[i]]++;
			}
			
			counts[0] = count[0];
			for(int i=1; i<5; i++) {
				counts[i] = counts[i-1] + count[i];
			}
			
			for(int i=data.length-1; i>0; i--) {
				result[counts[data[i]]-1] = data[i];
				counts[data[i]]--;
			}
			for(int i=0; i<8; i++) {
				System.out.print(result[i]);
			}
			
	}

}
