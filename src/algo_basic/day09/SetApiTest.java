package algo_basic.day09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetApiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		useSet(new HashSet<>());
		useSet(new LinkedHashSet<>());
		useSet(new TreeSet<>());
	}
	public static void useSet(Set<String> set) {
		set.add("hello");
		set.add("hello"); // 중복데이터가 허용되지 않음, 객체의 equals, hashcode 결과 확용
		set.add("hi");
		set.addAll(Arrays.asList("dream", "come", "true", "is", "apple", "ZZZZZ")); 
		// 출력 순서가 보장되지 않는다 - HashSet
		// 입력한 순서대로 뺄수 있다 - LinkedHashSet
		// 우선순위에 의해서 출력된다 - TreeSet
		System.out.println(set.getClass().getName() + " : " + set);
		// Set의 정보조회
		for (String string : set) {
			System.out.println(string);
		}
		// collection의 하위클래스이므로
		// size, isEmpty, add, contains...
		// 수정 불가
		// 삭제
		set.remove("hello");
		System.out.println("삭제 후 : " + set);
		// TreeSet의 기능 살펴보기
		if(set instanceof TreeSet) {
			TreeSet<String> tset = (TreeSet<String>)set;
			// treeSet은 검색과 관련된 기능 제공
			System.out.println("test의 앞의 요소 : " + tset.headSet("test"));
			System.out.println("test의 뒤의 요소 : " + tset.tailSet("test"));
			
			System.out.println("Dinner <= X < Test인 요소들 ? " + tset.subSet("Dinner", "test"));
			System.out.println(tset.first() + " : " + tset.pollFirst() + " : " + tset.pollLast());
		}
	}

}
