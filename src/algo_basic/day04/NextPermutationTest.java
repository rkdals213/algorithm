package algo_basic.day04;

import java.util.Arrays;

public class NextPermutationTest {
	private static int [] src = {1,2,4,3};
	public static void main(String[] args) {
		// 다음 순열을 찾으려면 처음 순열부터 시작 -> 정렬
		Arrays.sort(src);
		do {
			System.out.println(Arrays.toString(src));
		}while(nextPermutation());
		
	}
	private static boolean nextPermutation() {
		// step1 : src[i]<src[i+1]인 가장 뒤의 요소 찾기
		int i;
		for (i = src.length-2 ; i >= 0 ; i--) {
			if(src[i]<src[i+1]) {
				//System.out.println("발견! : " + i);
				break;
			}
		}
		
		// 여기까지 왔는데 i가 음수라면 --> 교환대상이 없다 --> 다음 순열이 없다
		if(i<0) {
			return false;
		}
		
		// step2 : i 뒤에 있는 요소들 중에서 src[i]보다 큰 처음 녀석 찾기(뒤에서부터 탐색)
		int j;
		for (j = src.length-1; j > i ; j--) {
			if(src[i] < src[j]) break;
		}
		
		// step3 : i와 j의 swap
		int temp = src[i];
		src[i] = src[j];
		src[j] = temp;
		
		//System.out.println(Arrays.toString(src));
		
		// step4 : i 뒤에 있는 녀석들 reverse
		int a = i+1;
		int b = src.length-1;
		while(a<b) {
			temp = src[a];
			src[a] = src[b];
			src[b] = temp;
			a++;
			b--;
		}
		System.out.println(Arrays.toString(src));
		
		
		return true;
		
	}

}
