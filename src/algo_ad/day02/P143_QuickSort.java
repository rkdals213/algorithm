package algo_ad.day02;

import java.util.Arrays;

public class P143_QuickSort {
	static int [] nums = {3,2,4,6,9,1,8,7,5};
	public static void main(String[] args) {
		// nums를 quicksort로 정렬해보자
		sort(nums,0,nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	/*
	 * 배열 a의 begin부터 end사이를 정렬하는 메서드
	 */
	public static void sort(int [] a, int begin, int end) {
		// 정렬대상의 크기가 1보다 커야한다
		if(begin < end) {
			int s = partition(a,begin,end);
			// 분할
			sort(a, begin, s-1);
			sort(a, s+1, end);
		}
	}
	public static int partition(int [] a, int begin, int end) {
		// 기준 위치 잡아주기
		int pi = begin;
		int left = begin;
		int right = end;
		while(left < right) {
			// 피봇 값보다 작으면 인덱스 증가, 그렇지 않으면 중지 --> 자리바꿈 대상
			while(a[left] <= a[pi]) {
				if(left >= end) {
					break;
				}
				left++;
			}
			while(a[right] >= a[pi]) {
				if(right <= begin) {
					break;
				}
				right--;
			}
			//바꿔야할 요소들이 나왔다면 자리 바꿈
			if(left < right) {
				swap(a,left,right);
			}
		}
		// 피봇값을 각 그룹의 경계에 집어넣기
		swap(a,pi,right);
		// 기준이 된 피봇 위치 넘겨주기
		return right; 
	}
	private static void swap(int [] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
