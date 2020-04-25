package algo_basic.day03;

import java.util.ArrayList;
import java.util.List;

public class SubSetTest {
	static char [] chars = {'A', 'B', 'C', 'D'};
	
	public static void main(String[] args) {
		// 위 원소들로 구성할 수 있는 부분집합을 찾아보자
		System.out.println("개수 : " + (1<<chars.length));
		for (int i = 0; i < (1<<chars.length); i++) {
			System.out.print(Integer.toBinaryString(i) + " : ");
			List<Character> subset = new ArrayList<>();
			for (int j = 0; j < chars.length; j++) {
				if( (i & 1<<j) > 0) { // 이러면 포함된 원소
					subset.add(chars[j]);
				}
			}
			System.out.println(subset);
		}
	}
}
