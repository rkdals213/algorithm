package algo_basic.day08;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {
	static ArrayList<Integer> array = new ArrayList<>();
	public static void insertionSort() {
		for (int i = 0; i < array.size(); i++) {
			for (int j = i-1; j >= 0; j--) {
				if(array.get(j) < array.get(i)) {
					array.add(j, array.get(i));
					array.remove(i+1);
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		int len = 10;
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			array.add(rand.nextInt(1000));
		}
		System.out.println(array);
		insertionSort();

		System.out.println(array);

	}

}
