package algo_basic.day02;

public class DirTraversal_exam {
	static int [][] nums = new int [5][5];
	
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
		
		for(int r=0; r<nums.length; r++) {
			for(int c=0; c<nums[r].length; c++) {
				int sum = 0;
				for(int d=0; d<dirsC.length; d++) {
					int nr = r+dirsC[d][0];
					int nc = c+dirsC[d][1];		
					
					if(isIn(nr, nc)) {
						sum += Math.abs(nums[nr][nc] - nums[r][c]);
					}
				}
				System.out.printf("%d, %d의 합은 %d%n", r, c, sum);
			}
		}
	}
	
	public static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r<nums.length && c<nums[0].length;
	}

}
