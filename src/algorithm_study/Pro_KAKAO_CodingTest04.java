package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Pro_KAKAO_CodingTest04 {
	static List<Point> list = new ArrayList<>();
	public static void main(String[] args) {
		long k = 10;
//		long [] roomnumber = {1,3,4,1,3,1};
		long [] roomnumber = {1,8,1,8,1,8};
		System.out.println(Arrays.toString(solution(k, roomnumber)));
	}
	static long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		for (int i = 0; i < answer.length; i++) {
			long a = room_number[i];
			if(list.isEmpty()) {
				list.add(new Point(room_number[i],room_number[i]));
				answer[i] = list.get(0).e;
			}else {
				boolean f = true;
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).isIn(a)) {
						if(a == list.get(j).e+1) {
							if(j+1 < list.size() && list.get(j+1).s == a) {
								list.get(j+1).e++; 
								answer[i] = list.get(j+1).e;
							}else {
								list.get(j).e++;
								answer[i] = list.get(j).e;
							}
						}else {
							list.get(j).e++;
							answer[i] = list.get(j).e;
						}
						
						f=false;
						break;
					}
				}
				if(f) {
					list.add(new Point(a,a));
					answer[i] = a;
				}
			}
			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					Long a = o1.s;
					Long b = o2.s;
					return a.compareTo(b);
				}
			});
			
			for (int j = 0; j < list.size()-1; j++) {
				if(list.get(j).e+1 == list.get(j+1).s){
					list.get(j+1).s = list.get(j).s;
					list.remove(j);
				}
			}
			System.out.println(list);
		}
		
		
		return answer;
	}

	static class Point{
		long s;
		long e;
		public Point(long s, long e) {
			super();
			this.s = s;
			this.e = e;
		}
		
		public boolean isIn(long a) {
			if(a <= e+1 && a >= s) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public String toString() {
			return "Point [s=" + s + ", e=" + e + "]";
		}
	}

}
