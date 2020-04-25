package algo_basic.day02;

public class DirTraversal_exam02 {
	static int [][] nums = new int [3][3];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dir4C();
		
	}
	static int [][] dirsC = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	public static void dir4C() {
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				nums[i][j] = (int) (Math.random()*10);
			}
		}
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				int temp = 0;
				temp = nums[i][j];
				nums[i][j] = nums[j][i];
				nums[j][i] = temp;
			}
		}
		System.out.println();
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<nums.length && c<nums[0].length;
	}

}
