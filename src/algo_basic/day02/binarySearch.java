package algo_basic.day02;

import java.util.Scanner;

public class binarySearch {
	
	public static void binSearch(int [] arr, int i, int j, int k)
	{
		if(i == j+1 || j == i+1) {
			System.out.println("숫자가 존재하지 않습니다");
		}
		else if(k == arr[(i+j)/2]){
			System.out.println("숫자를 찾았습니다 : " + (((i+j)/2)+1) + "번째 숫자");
		}
		else if(arr[i] == k){
			System.out.println("숫자를 찾았습니다 : " + (i+1) + "번째 숫자");
		}
		else if(arr[j] == k){
			System.out.println("숫자를 찾았습니다 : " + (j+1) + "번째 숫자");
		}
		else if(k > arr[(i+j)/2]) {
			i = (i + j)/2;
			binSearch(arr, i, j, k);
		}
		else if(k < arr[(i+j)/2]) {
			j = (i + j)/2;
			binSearch(arr, i, j, k);
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int [] array = {1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20};
		int [] array2 = {2,4,6,8,10,12,14,16,18,20,22,24,26,28,30};
		int i = 0; 
		int j = array2.length - 1;
		int k = 0;
		System.out.println("찾을 숫자를 입력하세요 ");
		k = scanner.nextInt();
		
		binSearch(array2, i, j, k);
		
	}

}