package algo_basic.day02;

public class ArrayTraversal {
	static int [][] nums = {{1,2,3},{4,5,6},{7,8,9}};
	public static void main(String[] args) {
		// 행 우선 출력
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
		}
		System.out.println();
		// 열 우선 출력
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[j][i] + " ");
			}
		}
		System.out.println();
		// 지그재그 출력
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[i][j + (nums[i].length-1-2*j) * (i%2)] + " ");
			}
		}

	}
	
	// 각 요소를 기준으로 4방 탐색 후 요소들의 합을 출력해보자
	
}
