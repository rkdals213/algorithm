package algo_ad.day01;

import java.util.Arrays;

public class Permutation {
	private static char [] src = {'A','B','C','D'};
	public static void main(String[] args) {
		//makePermutationIter();
		//makePermutation(0, 4, new char [4], new boolean [4]);
		//makePermutation(3, 0);
		makePermutation();
	}
	/*
	 * 반복문을 이용한 순열 생성
	 */
	public static void makePermutationIter() {
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src.length; j++) {
				if(i == j) {
					continue;
				}
				for (int j2 = 0; j2 < src.length; j2++) {
					if(i == j2 || j == j2) {
						continue;
					}
					System.out.printf("반복문 순열 : %c %c %c \n", src[i], src[j], src[j2]);
				}
			}
		}
	}
	/*
	 * 재귀를 이용한 순열 생성
	 * r 뽑을 개수
	 * temp 결과 저장
	 * visited 방문여부 저장
	 */
	private static void makePermutation(int r, int depth, char [] temp, boolean [] visited) {
		if(r == depth) {
			System.out.println(Arrays.toString(temp));
		}else {
			for (int i = 0; i < src.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					temp[r] = src[i];
					makePermutation(r+1, depth, temp, visited);
					visited[i] = false;
				}
			}
		}
	}
	/*
	 * swap을 이용한 순열 처리
	 * r
	 * depth
	 */
	private static void makePermutation(int r, int depth) {
		if(depth == r) {
			System.out.println(Arrays.toString(Arrays.copyOfRange(src, 0, r)));
		}
		else {
			for (int i = depth; i < src.length; i++) {
				swap(depth, i);
				makePermutation(r, depth+1);
				swap(depth, i);
			}
		}
	}
	public static void swap(int a, int b) {
		char temp = src[a];
		src[a] = src[b];
		src[b] = temp;
	} 
	/*
	 * 
	 */
	private static boolean nextPermutation() {
		int i;
		for (i = src.length-2; i >= 0; i--) {
			if(src[i]<src[i+1]) {
				break;
			}
		}
		if(i<0) {
			return false;
		}
		int j;
		for (j = src.length-1; j > i; j--) {
			if(src[i] < src[j]) {
				break;
			}
		}
		swap(i, j);
		for (int a = i+1, b=src.length-1; a<b; a++,b-- ) {
			swap(a,b);
		}
		return true;
	}
	
	public static void makePermutation() {
		// nextPermutation은 정렬된 상태에서 시작해야함
		Arrays.sort(src);
		do {
			System.out.println(Arrays.toString(src));
		}while(nextPermutation());
	}
}
