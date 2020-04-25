package algorithm_study;

import java.util.ArrayList;
import java.util.List;

public class Pro_Line_CodingTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String road = "111011110011111011111100011111";
		int n = 3;
		String road1 = "001100";
		int n1 = 5;
		System.out.println(solution(road, n));
		System.out.println(solution(road1, n1));
	}
	static public int solution(String road, int n) {
		int answer = -1;
		
		List<Point> list = new ArrayList<>();
		int start = 0;
		if(road.charAt(0) == '0') {
			while(start < road.length() && road.charAt(start) == '0') start++;
		}
		if(start != 0) list.add(new Point(0,start));
		for (int i = start; i < road.length(); i++) {
			int one = 0;
			int zero = 0;
			if(road.charAt(i)== '1') {
				while(i < road.length() && road.charAt(i) == '1') {
					i++;
					one++;
				}
				if(i < road.length() && road.charAt(i)== '0') {
					while(i < road.length() && road.charAt(i)== '0') {
						i++;
						zero++;
					}
				}
				i--;
			}
			if(one != 0) list.add(new Point(one, zero));
		}
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			int key = n;
			int length = 0;
			for (int j = i; j < list.size(); j++) {
				length += list.get(j).one;
				if(list.get(j).zero <= key) {
					length += list.get(j).zero;
					key -= list.get(j).zero;
				}else {
					length += key;
					break;
				}
			}
			answer = Math.max(answer, length);
					
		}
		return answer;
	}
	static class Point {
		int one;
		int zero;
		
		public Point(int one, int zero) {
			super();
			this.one = one;
			this.zero = zero;
		}

		@Override
		public String toString() {
			return "Point [one=" + one + ", zero=" + zero + "]";
		}
	}
}
