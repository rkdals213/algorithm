package algorithm_study;

import java.util.ArrayList;
import java.util.List;

public class ToPointer_구간삭제 {

	public static void main(String[] args) {
		int [] list = {1,9,2,7,6,8,5,3,4};
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < list.length; i++) {
			l.add(list[i]);
		}
		
		int front = 0;
		int back = 0;
		
		int a = 2;
		int b = 5;
		
		while(true) {			
			if(l.get(front) != b) {
				front++;
				if(front >= list.length && l.get(front) != b) break;
			}
			
			if(l.get(back) != a) {
				back++;
			}
			
			if(l.get(front) == b && l.get(back) == a) break;
		}
		
		System.out.println(front + " " + back);
		
		for (int i = 0; i < front-back+1; i++) {
			l.remove(back);
		}
		System.out.println(l.toString());
	}

}
