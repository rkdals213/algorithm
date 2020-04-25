package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_1258_D4_행렬찾기 {
	private static int [][] dirs = {{1,0},{0,1}};
	private static ArrayList<Point> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			int [][] map = new int [N][N];			
			for (int j = 0; j < N; j++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(temp.nextToken());
				}
			}
			find(map);
			list.sort(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					if (o1.sum>o2.sum) {
						return 1;
					}else if(o1.sum==o2.sum) {
						if (o1.x>o2.x) {
							return 1;
						}else if(o1.x==o2.x) {
							return 0;
						}else {
							return -1;
						}
					}else {
						return -1;
					}
				}
			});
			sb.append(list.size()).append(" ");
			for (int j = 0; j < list.size(); j++) {				
				sb.append(list.get(j).x).append(" ").append(list.get(j).y).append(" ");
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	static void find(int [][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {				
				if(map[i][j] != 0) {
					int countx = 0;
					int county = 0;
					int tempy = 0;
					while(isIn(i+countx,j,map.length) && map[i+countx][j] != 0) {
						while(isIn(i+countx,j+county,map.length) && map[i+countx][j+county] != 0) {
							map[i+countx][j+county] = 0;
							county++;
						}					
						countx++;
						tempy = county;
						county = 0;						
					}		
					list.add(new Point(countx, tempy));	
				}							
			}
		}		
	}
	
	
	static boolean isIn(int x, int y, int N) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	
	static class Point{
		int x;
		int y;
		int sum;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.sum = x*y;
		}		
	}

}
