package algo_basic.day02;

import java.util.Arrays;
import java.util.Comparator;

public class SortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"dream", "is", "come", "true"};
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
		// 글자수를 기준으로 오름차순 정렬
		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				Integer n1 = o1.length();
				Integer n2 = o2.length();
				if(n1 == n2) {
					return o1.compareTo(o2)*-1;
				}
				else {
					return n1.compareTo(n2);
				}				
			}
		});
		System.out.println(Arrays.toString(strs));
		
		
	}

}
