package monthlyTest01;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
	static int [][] map = new int [19][19];
	static int [][] dir = {{1,1},{1,0},{0,1},{-1,1}};
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		// 구현하세요.
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int winner = 0;
		for (int i = 0; i < map.length; i++) {
			int x;
			int y;
			for (int j = 0; j < map.length; j++) {
				
				int turn = map[i][j];
				if(turn == 1) {				
					for (int k = 0; k < dir.length; k++) {
						int count = 0;
						x=i;
						y=j;
						for (int k2 = 0; k2 < 4; k2++) {
							x += dir[k][0];
							y += dir[k][1];
							
							if(isIn(x,y) && map[x][y] == 1) {
								count++;
								
							}else {
								break;
							}							
						}	
						if(count == 4) {
							System.out.println(1);
							System.out.println((i+1) + " " + (j+1));
							winner = 2;
							return;
						}
					}					
				}else if(turn == 2) {					
					for (int k = 0; k < dir.length; k++) {
						int count = 0;
						x=i;
						y=j;
						for (int k2 = 0; k2 < 4; k2++) {
							x += dir[k][0];
							y += dir[k][1];
							
							if(isIn(x,y) && map[x][y] == 2) {
								count++;
							}else {
								break;
							}							
						}	
						if(count == 4) {
							System.out.println(2);
							System.out.println((i+1) + " " + (j+1));
							winner = 2;
							return;
						}
					}
				}
				else {
					continue;
				}
			}
			
		}	
		System.out.println(0);
		
		
	}
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=00 && x<map.length && y<map.length;
	}

}
