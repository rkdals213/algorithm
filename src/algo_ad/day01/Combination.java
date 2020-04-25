package algo_ad.day01;

import java.util.Arrays;

public class Combination {
	private static char [] src = {'A','B','C','D'};
	public static void main(String[] args) {
		makeCombination(2, new char[2], 0);
		System.out.println();
		makeCombination(src.length, 2, new char [2]);

	}
	
	// nCr = n-1Cr-1 + n-cCr을 이용해 보면
	private static void makeCombination(int n, int r, char [] temp) {
		if(r==0) {
			// 조합이 성공해서 종료
			System.out.println(Arrays.toString(temp));
		}else if(n<=0) {
			// 조합이 실패해서 종료
			return;
		}else {
			// 원소를 사용한다
			temp[r-1] = src[n-1];
			makeCombination(n-1, r-1, temp);
			makeCombination(n-1, r, temp);
			
		}
	}
	
	//순열의 형태를 이용한 조합 구하기	
	private static void makeCombination(int r, char [] temp, int si) {
		if(r==0) {
			System.out.println(Arrays.toString(temp));
		}else {
			for (int i = si; i < src.length; i++) {
				temp[r-1] = src[i];
				makeCombination(r-1, temp, i+1);
			}
		}
	}
}
