package algo_basic.day03;

import java.util.Arrays;

public class VisitedRecur {
	private static char [] src = {'A','B','C','D'};
	public static void main(String[] args) {
		int r=3;
		permutation1(r, new char [r], 0, new boolean [src.length]);
		
	}
	// src원소 n개에서 r개를 구하는 순열을 모두 찾아보자
	// r : 뽑을 개수
	// temp : 뽑아서 모은 녀석들
	// current : 현재 선택된 요소의 temp에서의 idx
	// visited : 방문여부를 저장해놓을 배열
	public static void permutation1(int r, char [] temp, int current, boolean [] visited) {
		// base case
		if(current == r) {
			// 완료 상태 --> temp 출력
			System.out.println(Arrays.toString(temp));
			return;
		}else {
			// 가능한 녀석들 다 대보기
			for (int i = 0; i < src.length; i++) {
				// 마냥 쓸수는 없고 아직 사용전인지 환인필요
				if (!visited[i]) {
					// 미사용 -> 이제 쓸수 있다
					temp[current] = src[i]; // 선택 완료
					visited[i] = true;
					permutation1(r, temp, current+1, visited);
					visited[i] = false;
				}
			}
		}
	}
}
