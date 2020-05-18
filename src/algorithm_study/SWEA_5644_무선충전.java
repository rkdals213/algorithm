package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5644_무선충전 {
	static int [][][] map;
	static boolean [][][] visited;
	static int [][] dir4 = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static int result;
	static List<Integer> powerList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			result = 0;
			powerList = new ArrayList<>();
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(temp.nextToken());
			int A = Integer.parseInt(temp.nextToken());
			int [] a = new int [N+1]; 
			int [] b = new int [N+1]; 
			map = new int [10][10][A+1];
			visited = new boolean [N][N][A+1];
			temp = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(temp.nextToken());
			}
			temp = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				b[i] = Integer.parseInt(temp.nextToken());
			}
			BFS(A, br);
			move(a, b, N, A);
			sb.append("#").append(tc).append(" ").append(result).append("\n");			
		}
		System.out.println(sb);
	}
	
	static void move(int [] a, int [] b, int N, int A) {
		int AX = 0;
		int AY = 0;
		int BX = 9;
		int BY = 9;
		for (int i = 0; i < N+1; i++) {		
			AX += dir4[a[i]][0];
			AY += dir4[a[i]][1];
			BX += dir4[b[i]][0];
			BY += dir4[b[i]][1];
			
			PriorityQueue<Power> powerA = new PriorityQueue<>();
			PriorityQueue<Power> powerB = new PriorityQueue<>();
			for (int j = 1; j < A+1; j++) {
				int ta = map[AX][AY][j];
				int tb = map[BX][BY][j];				
				if(ta!=0) powerA.add(new Power(ta, powerList.get(ta)));
				if(tb!=0) powerB.add(new Power(tb, powerList.get(tb)));
			}

			if(powerA.isEmpty() && !powerB.isEmpty()) {
				result += powerB.poll().power;
			}else if(!powerA.isEmpty() && powerB.isEmpty()) {
				result += powerA.poll().power;
			}else if(!powerA.isEmpty() && !powerB.isEmpty()){
				Power pa = powerA.poll();
				Power pb = powerB.poll();
				if(pa.A != pb.A) {
					result += pa.power;
					result += pb.power;
				}else {
					if(powerA.isEmpty() && !powerB.isEmpty()) {
						result += pa.power;
						result += powerB.poll().power;
					}else if(!powerA.isEmpty() && powerB.isEmpty()) {
						result += powerA.poll().power;
						result += pb.power;
					}else if(!powerA.isEmpty() && !powerB.isEmpty()){
						Power paa = powerA.poll();
						Power pbb = powerB.poll();
						result += pa.power;
						result += Math.max(paa.power, pbb.power);
					}else if(powerA.isEmpty() && powerB.isEmpty()){
						result += pa.power/2;
						result += pb.power/2;
					}
				}
			}			
		}		
	}
	
	static void BFS(int A, BufferedReader br) throws IOException {
		StringTokenizer temp = null;
		PriorityQueue<Point> pq = new PriorityQueue<>();
		powerList.add(0);
		for (int i = 1; i <= A; i++) {
			temp = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(temp.nextToken())-1;
			int x = Integer.parseInt(temp.nextToken())-1;
			int C = Integer.parseInt(temp.nextToken());
			int P = Integer.parseInt(temp.nextToken());
			powerList.add(P);
			pq.add(new Point(x, y, C, P, i));
		}
		while(!pq.isEmpty()) {
			Point t = pq.poll();
			map[t.x][t.y][t.A] = t.A;
			for (int i = 1; i < 5; i++) {
				int x = t.x + dir4[i][0];
				int y = t.y + dir4[i][1];
				if(isIn(x, y) && !visited[x][y][t.A]) {
					if(t.C > 0) {
						visited[x][y][t.A] = true;
						pq.add(new Point(x, y, t.C-1, t.P, t.A));
					}
				}
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<10 && y<10;
	}
	
	static class Point implements Comparable<Point>{
		int x,y;
		int C;
		int P;
		int A;
		public Point(int x, int y, int c, int p, int a) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
			A = a;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", C=" + C + ", P=" + P + "]";
		}
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.P, o.P);
		}
		
	}
	
	static class Power implements Comparable<Power>{
		int A, power;

		public Power(int a, int power) {
			super();
			A = a;
			this.power = power;
		}

		public String toString() {
			return "Power [A=" + A + ", power=" + power + "]";
		}

		public int compareTo(Power o) {
			return Integer.compare(o.power, this.power);
		}

		
	}

}
