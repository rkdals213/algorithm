package algo_basic.day02;

import java.util.Arrays;

public class SubSet0 {
	static int [] nums = {1,2};
	public static void main(String[] args) {
		// nums의 모든 부분집합을 출력
		int th = 0;
		int [] temp = new int [nums.length];
		for(int i=0; i<nums.length; i++) {
			temp[0] = i%2;
			for(int j=0; j<nums.length; j++) {
				temp[1] = j%2;
				System.out.println(++th + " : "+ Arrays.toString(temp));
			}
		}		
	}
}
