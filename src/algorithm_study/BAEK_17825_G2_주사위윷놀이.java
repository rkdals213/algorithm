package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17825_G2_주사위윷놀이 {
	static int [] move = new int [10];
	static int [][] node = new int [33][2];
	static boolean [] exist = new boolean [33];
	static Point horse[] = new Point[4];
	static boolean horseend[] = new boolean[4];
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			move[i] = Integer.parseInt(temp.nextToken());
		}
		for (int i = 0; i < 4; i++) {
			horse[i] = new Point(0,0);
		}
		
		start();
		DFS(0);
		System.out.println(result);
	}
	
	static void DFS(int r) {
		if(r == 10) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += horse[i].point;
			}	
			if(sum > result) {
				result = sum;
			}
		}else {
			for (int i = 0; i < 4; i++) {
				if(horseend[i]) continue;
				
				int k = move[r];
				int start = horse[i].startNode;
				int point = horse[i].point;		
				
				if(visitedCheck(start, k)) {
					exist[start] = false;
					int after = move(start, k);				
					
					if(after == 32) {
						horseend[i] = true;
					}else {
						exist[after] = true;
						horse[i].point += node[after][1];
					}
					horse[i].startNode = after;
					
					DFS(r+1);
					
					exist[after] = false;
					horse[i].startNode = start;
					horse[i].point = point;	
					exist[start] = true;
					horseend[i] = false;
				}
			}				
		}
	}
	
	static int move(int i, int k) {
		int s = i;
		int t = 0;
		if(i==5) {
			s = 21;
			k--;
		}else if(i==10) {
			s = 24;
			k--;
		}else if(i==15) {
			s = 26;
			k--;
		}
		
		for (int j = 0; j < k; j++) {			
			t = node[s][0];
			s = t;
		}
		return s;
	}
	
	static boolean visitedCheck(int i, int k) {
		int s = i;
		int t = 0;
		if(i==5) {
			s = 21;
			k--;
		}else if(i==10) {
			s = 24;
			k--;
		}else if(i==15) {
			s = 26;
			k--;
		}
		for (int j = 0; j < k; j++) {			
			t = node[s][0];
			s = t;
		}
		if(exist[s]) {
			return false;
		}else {
			return true;
		}
	}
	
	
	static class Point {
		int startNode;
		int point;
		public Point(int startNode, int point) {
			super();
			this.startNode = startNode;
			this.point = point;
		}
		@Override
		public String toString() {
			return "Point [startNode=" + startNode + ", point=" + point + "]";
		}		
	}
	
	static void start() {
		node[0][0]=1;
		node[1][0]=2;
		node[2][0]=3;
		node[3][0]=4;
		node[4][0]=5;
		node[5][0]=6;
		node[6][0]=7;
		node[7][0]=8;
		node[8][0]=9;
		node[9][0]=10;
		node[10][0]=11;
		node[11][0]=12;
		node[12][0]=13;
		node[13][0]=14;
		node[14][0]=15;
		node[15][0]=16;
		node[16][0]=17;
		node[17][0]=18;
		node[18][0]=19;
		node[19][0]=20;
		node[20][0]=32;
		node[21][0]=22;
		node[22][0]=23;
		node[23][0]=29;
		node[24][0]=25;
		node[25][0]=29;
		node[26][0]=27;
		node[27][0]=28;
		node[28][0]=29;
		node[29][0]=30;
		node[30][0]=31;
		node[31][0]=20;
		node[32][0]=32;
		
		node[0][1]=0;
		node[1][1]=2;
		node[2][1]=4;
		node[3][1]=6;
		node[4][1]=8;
		node[5][1]=10;
		node[6][1]=12;
		node[7][1]=14;
		node[8][1]=16;
		node[9][1]=18;
		node[10][1]=20;
		node[11][1]=22;
		node[12][1]=24;
		node[13][1]=26;
		node[14][1]=28;
		node[15][1]=30;
		node[16][1]=32;
		node[17][1]=34;
		node[18][1]=36;
		node[19][1]=38;
		node[20][1]=40;
		node[21][1]=13;
		node[22][1]=16;
		node[23][1]=19;
		node[24][1]=22;
		node[25][1]=24;
		node[26][1]=28;
		node[27][1]=27;
		node[28][1]=26;
		node[29][1]=25;
		node[30][1]=30;
		node[31][1]=35;
		node[32][1]=0;
	}
}
