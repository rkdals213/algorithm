package algo_basic.day02;

public class DirTraversal {
	static int [][] nums = {{1,2,3},{4,5,6},{7,8,9}};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dir4C();
		//dir4X();
		dir48();
	}
	static int [][] dirsC = {{-1,0}, {1,0}, {0,1}, {0,-1}};
	static int [][] dirsX = {{-1,-1}, {-1,1}, {1,1}, {1,-1}};
	static int [][] dirs8 = {{-1,-1}, {-1,1}, {1,1}, {1,-1},{-1,0}, {1,0}, {0,1}, {0,-1}};
	public static void dir4C() {
		for(int r=0; r<nums.length; r++) {
			for(int c=0; c<nums[r].length; c++) {
				int sum = 0;
				for(int d=0; d<dirsC.length; d++) {
					int nr = r+dirsC[d][0];
					int nc = c+dirsC[d][1];		
					
					if(isIn(nr, nc)) {
						sum+=nums[nr][nc];
					}
				}
				System.out.printf("%d, %d의 합은 %d%n", r, c, sum);
			}
		}
	}
	public static void dir4X() {
		for(int r=0; r<nums.length; r++) {
			for(int c=0; c<nums[r].length; c++) {
				int sum = 0;
				for(int d=0; d<dirsX.length; d++) {
					int nr = r+dirsX[d][0];
					int nc = c+dirsX[d][1];		
					
					if(isIn(nr, nc)) {
						sum+=nums[nr][nc];
					}
				}
				System.out.printf("%d, %d의 합은 %d%n", r, c, sum);
			}
			
		}
	}
	public static void dir48() {
		for(int r=0; r<nums.length; r++) {
			for(int c=0; c<nums[r].length; c++) {
				int sum = 0;
				for(int d=0; d<dirs8.length; d++) {
					int nr = r+dirs8[d][0];
					int nc = c+dirs8[d][1];		
					
					if(isIn(nr, nc)) {
						sum+=nums[nr][nc];
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
