package algo_ad.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_10972_S4_다음순열 {
	static int [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer temp = new StringTokenizer(br.readLine()); 
		list = new int [N];
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(temp.nextToken());
		}
		nextPer();
	}
	public static boolean nextPerm() {
		int i;
		for (i = list.length-2; i >= 0; i--) {
			if(list[i]<list[i+1]) {
				break;
			}
		}
		if(i<0) {
			return false;
		}
		int j;
		for (j = list.length-1; j > i; j--) {
			if(list[i] < list[j]) {
				break;
			}
		}
		swap(i, j);
		for (int a = i+1, b=list.length-1; a<b; a++,b-- ) {
			swap(a,b);
		}
		return true;
	}
	public static void swap(int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	} 
	
	public static void nextPer() {
		if(nextPerm()) {
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i] + " ");
			}
		}else {
			System.out.println(-1);
		}
	}

}
