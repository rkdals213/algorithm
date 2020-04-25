package algo_basic.day08;

import java.util.Arrays;

public class MergeSort {
	
	public static void merge_sort(int [] arr, int si, int ei) {
		// 종료 조건 : 크기가 1이면 더이상 나눌 필요가 없다
		if(si == ei) {
			return;
		}
		// 그렇지 않다면 - 반씩 나눠가며 재귀 호출
		int mi = (si+ei)/2;
		merge_sort(arr, si, mi);
		merge_sort(arr, mi+1, ei);
		// 분할이 완료되면 --> 맨 아래 가지에서 만난 두 재귀의 결과에서 병합
		merge(arr, si, mi, ei);		
	}
	
	public static void merge(int [] arr, int si, int mi, int ei) {
		// 병합 정렬은 별도의 메모리 공간을 필요로 한다
		int [] temp = new int [arr.length];
		int li = si; // 왼쪽 배열의 시작점
		int ri = mi+1; // 오른쪽 배열의 시작점
		int ti = si; // 결과를 저장할 임시 배열의 시작점
		
		while(li <= mi && ri <= ei) { // 양 부분에서 아직 처리할 데이터가 있다면..
			if(arr[li] <= arr[ri]) {
				temp[ti++] = arr[li++];
			}else {
				temp[ti++] = arr[ri++];
			}
		}
		// 한쪽에만 데이터가 남은 경우 - 남은 데이터 사용하기
		while(li <= mi) {
			temp[ti++] = arr[li++];
		}
		while(ri <= ei) {
			temp[ti++] = arr[ri++];
		}
		// temp에 정렬된 데이터를 arr에 넘겨주기
		for (int i = si; i <= ei; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {69,10,30,2,16,8,31,22};
		merge_sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
