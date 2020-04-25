package algo_basic.day02;

import java.util.Arrays;
import java.util.Comparator;

public class BasicSort {
	static int [] data = {0,4,1,3,1,2,4,1};
	static String [] strs = {"my","dream","is","java","script"};
	public static void main(String[] args) {
		//sort1();
		//sort2();
		sort3();

	}
	public static void sort1() {
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));
	}
	
	public static void sort2() {
		Hero [] heros = {new Hero(100,"Hulk"), 
				new Hero(200,"CA"), 
				new Hero(300,"IronMan")};
		Arrays.sort(heros);
		System.out.println(Arrays.toString(heros));
	}
	
	public static void sort3() {
		Hero [] heros = {new Hero(100,"Hulk"), 
				new Hero(200,"CA"), 
				new Hero(300,"IronMan")};
		Arrays.sort(heros, new Comparator<Hero>() {

			@Override
			public int compare(Hero o1, Hero o2) {
				/*
				if (o1.power>o2.power) {
					return -1;
				}else if(o1.power==o2.power) {
					return 0;
				}else {
					return 1;
				}*/
				return o1.power.compareTo(o2.power);
				//return o1.compareTo(o2)*(-1);
			}
		});
		
		System.out.println(Arrays.toString(heros));
	}
	
	static class Hero implements Comparable<Hero>{
		Integer power;
		String name;
		
		public Hero(int power, String name) {
			this.power = power;
			this.name = name;
		}

		@Override
		public int compareTo(Hero o) {
			return this.name.compareTo(o.name);
		}
		
		public String toString() {
			return name+": "+power;
		}
		
	}

}
