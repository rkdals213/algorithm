package algo_basic.day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayVsLinked {

	public static void addSequencial(List<Integer> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			list.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(list.getClass().getName()+ " : "+(end-start));
	}	
	
	public static void addNonSequencial(List<Integer> list) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			list.add(0,i);
		}
		long end = System.currentTimeMillis();
		System.out.println(list.getClass().getName()+ " : "+(end-start));
	}	
	
	public static void main(String[] args) {
		addSequencial(new LinkedList<>());
		addSequencial(new ArrayList<>());
		addNonSequencial(new LinkedList<>());
		addNonSequencial(new ArrayList<>());
	}

}
