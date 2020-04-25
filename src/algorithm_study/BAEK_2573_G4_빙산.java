package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_2573_G4_빙산 {
	static int N;
	static int M;
	static int [][] map;
	static int [][] mapcopy;
	static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int[N][M];
		mapcopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		int year = 0;
		outer : while(true) {
			visited = new boolean[N][M];
			boolean flag = false;
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						count++;
						BFS(i,j);	
						flag = true;
						if(count > 1) {
							break outer; 
						}
					}
				}
			}
			if(!flag) {
				System.out.println(0);
				return;
			}
			year++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0) {
						int blank = 0;
						for (int k = 0; k < dirs.length; k++) {
							int x = i+dirs[k][0];
							int y = j+dirs[k][1];
							if (isIn(x,y) && map[x][y] == 0) {
								blank++;
							}
						}
						mapcopy[i][j] = map[i][j]-blank;
						if(mapcopy[i][j] < 0) {
							mapcopy[i][j] = 0;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				map[i] = mapcopy[i].clone();
			}
		}
		System.out.println(year);
	}

	static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y,0));
		while(!queue.isEmpty()) {
			Point t = queue.poll();			
			for (int i = 0; i < dirs.length; i++) {
				int xx = t.x + dirs[i][0];
				int yy = t.y + dirs[i][1];
				if(isIn(xx, yy) && map[xx][yy] != 0 && !visited[xx][yy]) {
					visited[xx][yy] = true;
					queue.add(new Point(xx,yy,0));
				}
			}
		}
	}

	static class Point{
		int x;
		int y;
		int count;
		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}		
	}

	static boolean isIn(int x,int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}

}
