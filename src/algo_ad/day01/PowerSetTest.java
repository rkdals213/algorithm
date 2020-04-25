package algo_ad.day01;

import java.util.ArrayList;
import java.util.List;

public class PowerSetTest {
	private static int [] arr = {3,6,7,1,5,4};
	public static void main(String[] args) {
		subset();
	}
	// 반복문 이용해서 부분집합을 구하는 메서드를 작성
	
	// bitmasking을 이용해서 부분집합을 구해보세요
	public static void subset() {
		for (int i = 0; i < (1<<arr.length); i++) {			
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < arr.length; j++) {
				if((i & 1<<j) > 0) {
					list.add(arr[j]);
				}
			}
			System.out.println(list);
		}
	}
}
