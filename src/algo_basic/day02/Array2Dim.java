package algo_basic.day02;

import java.util.Arrays;
import java.util.Comparator;

import algo_basic.day02.BasicSort.Hero;

public class Array2Dim {

	public static void main(String[] args) {
		//int a;
		int [] arr1 = {1,2,3};
		int [][] arr2 = new int [2][4];
		arr2[1][3] = 100;
		//System.out.println(arr2.length);
		//System.out.println(arr2[1][3]);
		//System.out.println(Arrays.toString(arr1));
		//System.out.println((Arrays.toString(arr2)));
		for(int [] row: arr2) {
			System.out.println((Arrays.toString(row)));
		}
		
		// 정렬하는 함수
		Arrays.sort(arr2, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				Integer sum1 = 0;
				Integer sum2 = 0;
				for(int num: o1) {
					sum1 += num;
				}
				for(int num: o2) {
					sum2 += num;
				}
				return sum1.compareTo(sum2)*-1;
			}
		});
		
		// 결과값 출력
		for(int [] row: arr2) {
			System.out.println((Arrays.toString(row)));
		}
	
	}
}
