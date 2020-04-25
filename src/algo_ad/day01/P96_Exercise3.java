package algo_ad.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P96_Exercise3 {
	private static int [] src = {-1,3,-9,6,7,-6,1,5,4,-2};
	static int max1 = Integer.MIN_VALUE;
	static int max2 = Integer.MIN_VALUE;
	public static void main(String[] args) {
		makeSubset();
		makeComb(2, 0, new int [2]);
		System.out.println(max1);
		System.out.println();
		
		makePerm(2, new int [2], new boolean [src.length]);
		System.out.println(max2);
	}
	// src의 모든 부분 집합 중 합의 0이 되는 것을 모두 출력
	private static void makeSubset() {
		for (int i = 1; i < (1<<src.length); i++) {
			List<Integer> list = new ArrayList<>();
			int sum = 0;
			for (int j = 0; j < src.length; j++) {
				if((i & (1<<j)) > 0) {
					list.add(src[j]);
					sum += src[j];
				}								
			}
			if(sum == 0 && !list.isEmpty()) {
				System.out.println(list);
			}	
		}
	}
	// src에서 임의의 두개의 원소를 더해서 만들 수 있는 최대 수
	private static void makeComb(int r, int s, int [] temp) {
		if(r==0) {
			int sum = 0;
			for (int i = 0; i < temp.length; i++) {
				sum += temp[i]; 
			}
			if(sum > max1) {
				max1 = sum;
				//System.out.println(Arrays.toString(temp));
			}			
		}else {
			for (int i = s; i < src.length; i++) {
				temp[r-1] = src[i];
				makeComb(r-1, i+1, temp);
			}
		}
	}
	// src에서 임의의 두 양수를 뽑아서 만들 수 있는 2자리 정수 중 가장 큰것은?
	private static void makePerm(int r, int [] temp, boolean [] visited) {
		if(r==0) {
			int num = temp[0]*10 + temp[1];
			max2 = Math.max(max2, num);
		}else {
			for (int i = 0; i < src.length; i++) {
				if(!visited[i] && src[i] >= 0) {
					visited[i] = true;
					temp[r-1] = src[i];
					makePerm(r-1, temp, visited);
					visited[i] = false;
				}
			}
		}
	}
}
