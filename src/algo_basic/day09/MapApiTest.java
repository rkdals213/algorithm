package algo_basic.day09;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useMap(new HashMap<>());
		useMap(new LinkedHashMap<>());
		useMap(new TreeMap<>());
	}
	
	public static void useMap(Map<Integer, String> map) {
		int [] keys = {1,-1,0,2,-2,-2};
		
		for (int i : keys) {
			map.put(i, Integer.toString(i));
		}
		System.out.println(map.getClass().getName()+ " : " + map);
		
		// 수정
		// put - 처음 들어오면 insert, 동일한 키일 경우 새로운 데이터로 수정
		map.put(-2, "200");
		map.replace(-1, "100");
		System.out.println(map);
		
		// 탐색1 - key만 가져와서 value조회하기
		Set<Integer> ketSet = map.keySet();
		for(Integer key : ketSet) {
			System.out.println(key + " : " + map.get(key));
		}
		
		// 탐색2 - key:value의 조합인 Entry 사용
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// 탐색3 - value 중점
		Collection<String> values = map.values();
		System.out.println(values);
		
		System.out.println(map.containsKey(1) + " " + map.containsValue("100"));
		
		if(map instanceof TreeMap) {
			TreeMap<Integer, String> tmap = (TreeMap<Integer, String>)map;
			System.out.println(tmap.headMap(0));
			System.out.println(tmap.tailMap(0));
			System.out.println(tmap.subMap(-1,1));
		}
	}

}
