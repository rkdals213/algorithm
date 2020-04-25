package algo_ad.day01;

import java.util.ArrayList;
import java.util.List;

public class P32_Exercise1 {
	private static String [] src = {"00000010001101","0000000111100000011000000111100110000110000111100111100111111001100111"};
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < src.length; i++) {
			String str = src[i];
			for (int j = 0; j < str.length(); j+=7) {
				list.add(calc(str,j,j+7));
			}
			System.out.println(str);
			System.out.println(list);
		}
	}
	// 경계값을 던져주고 문자열을 십진수로 변경해보자
	public static int calc(String data, int from, int to) {
		int sum = 0;
		for (int i = from; i < to; i++) {
			if(data.charAt(i) == '1') {
				sum += 1 << (6 - i & 7);
			}
		}
		
		return sum;
	}

}
