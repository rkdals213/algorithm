package algorithm_study;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import java.util.StringTokenizer;
import java.util.TreeMap;

public class Pro_KAKAO_CodingTest02 {
	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s1 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		String s2 = "{{20,111},{111}}";
		String s3 = "{{123}}";
		String s4 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";	


//		solution(s);
		System.out.println(Arrays.toString(solution(s1)));
//		solution(s2);
//		solution(s3);
//		solution(s4);
	}

	static public int [] solution(String s) {
		StringTokenizer t = new StringTokenizer(s, "},{");
		Map<Integer, Integer> map = new TreeMap<>();
		while(t.hasMoreTokens()) {
			int k = Integer.parseInt(t.nextToken());
			if(map.containsKey(k)) {
				int v = map.get(k);
				map.replace(k, v+1);
			}else {
				map.put(k, 1);
			}
		}
		
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				Integer a = o1.getValue();
				Integer b = o2.getValue();
				return b.compareTo(a);
			}

		});
		
		int answer [] = new int [list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i).getKey();
		}
		return answer;
	}
	
}
