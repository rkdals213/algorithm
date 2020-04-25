package algo_basic.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum { // 부분집합의 합 구하기
	static int [] arr = {-7, -3, -2, 5, 8}; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("개수 : " + (1<<arr.length));
		for (int i = 1; i < (1<<arr.length); i++) {
			//System.out.print(Integer.toBinaryString(i) + " : ");
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if((i & (1<<j)) > 0) {
					sum += arr[j];
				}
			}
			if(sum == 0) {				
				System.out.println(sum + " 참");
			}/*else {
				System.out.println(sum + " 거짓");
			}*/
		}
	}
	
}
