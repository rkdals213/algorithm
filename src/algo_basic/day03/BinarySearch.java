package algo_basic.day03;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] src = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearchRecur(src, 10, 0, src.length-1));
		System.out.println(binarySearchRecur(src, 1, 0, src.length-1));
	}
	public static int binarySearchRecur(int [] arr, int target, int from, int to) {
		// 종료 조건
		if(from > to) {
			return -1;
		}
		int mid = (from + to)/2;
		if(arr[mid]==target) {
			return mid;
		}else if(arr[mid] > target) {
			return binarySearchRecur(arr, target, from, mid - 1);
		}else {
			return binarySearchRecur(arr, target, mid + 1, to);
		}
	}
}	
