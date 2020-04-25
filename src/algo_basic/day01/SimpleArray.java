package algo_basic.day01;

import java.sql.Array;
import java.util.Arrays;

public class SimpleArray {

	public static void main(String[] args) {
		int [] num = new int[4]; // 배열 선언 및 할당 > 디폴트 초기화 상태
		String [] strs = {"hello", "java", "world"}; // 배열 선언과 동시에 할당 및 초기화
		
		for(int i = 0; i<strs.length; i++) {
			System.out.println(strs[i]); 			
		}
		for(String str : strs) {
			System.out.println(str);
		}
		
		System.out.println(Arrays.toString(strs)); // 배열 내용의 출력
		
		Arrays.fill(strs, "filled"); // 배열의 내용 채우기
		System.out.println(Arrays.toString(strs));
	}
}
