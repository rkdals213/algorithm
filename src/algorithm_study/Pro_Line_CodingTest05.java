package algorithm_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Pro_Line_CodingTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] dataSource = {{"doc1", "t1", "t2", "t3"},
				{"doc2", "t0", "t2", "t3"},
				{"doc3", "t1", "t6", "t7"},
				{"doc4", "t1", "t2", "t4"},
				{"doc5", "t6", "t100", "t8"},
				{"Doc1", "t1", "t2", "t3"}};
		String [] tags = {"t1", "t2", "t3"};
		System.out.println(Arrays.toString(solution(dataSource, tags)));

	}
	static public String[] solution(String[][] dataSource, String[] tags) {
		String[] answer = {};
		Map<String, Set<String>> map = new TreeMap<>();
		for (int i = 0; i < dataSource.length; i++) {
			Set<String> temp = new HashSet<>();
			if(!map.containsKey(dataSource[i][0])) {
				for (int j = 1; j < dataSource[i].length; j++) {
					temp.add(dataSource[i][j]);
				}
				map.put(dataSource[i][0], temp);
			}else {
				temp = map.get(dataSource[i][0]);
				for (int j = 1; j < dataSource[i].length; j++) {
					temp.add(dataSource[i][j]);
				}
				map.replace(dataSource[i][0], temp);
			}
		}

		List<Point> list = new ArrayList<>();

		for (Map.Entry<String, Set<String>> t : map.entrySet()) {
			String temp = t.getKey();
			Set<String> valuetemp = t.getValue();
			int c = 0;
			
			for (int j = 0; j < tags.length; j++) {
				if(valuetemp.contains(tags[j])) {
					c++;
				}
			}
			if(c > 0) list.add(new Point(temp,c));
		}

		list.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				Integer a1 = o1.count;
				Integer a2 = o2.count;
				if(a1 == a2) {
					return o1.docs.compareTo(o2.docs);
				}
				return a2.compareTo(a1);
			}
		});

//		System.out.println(map);
//		System.out.println(list);
		if(list.size() <= 10) answer = new String[list.size()];
		else answer = new String[10];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).docs;
		}
		return answer;
	}
	static class Point {
		String docs;
		int count;

		public Point(String docs, int count) {
			super();
			this.docs = docs;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [docs=" + docs + ", count=" + count + "]";
		}
	}
}
