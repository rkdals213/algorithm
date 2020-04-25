package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class SWEA_1251_D4_하나로 {
	static int [] root;
	static int N;
	static int [][] V;
	static long result;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			result = 0;
			temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());			
			V = new int [N][2];
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {				
				V[j][0] = Integer.parseInt(temp.nextToken());		
			}
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				V[j][1] = Integer.parseInt(temp.nextToken());		
			}
			
			temp = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(temp.nextToken());
			
			List<long []> list = new ArrayList<>();
			
			for (int j = 0; j < N; j++) {
				int sx = V[j][0];
				int sy = V[j][1];
				int sp = j;
				for (int k = j+1; k < N; k++) {
					int ex = V[k][0];
					int ey = V[k][1];
					int ep = k; 
					long dx = sx - ex;
					long dy = sy - ey;
					long distance = dx*dx + dy*dy;
					
					long[] t = {sp,ep,distance};
					list.add(t);
				}
			}
			
			list.sort(new Comparator<long[]>() {

				@Override
				public int compare(long[] o1, long[] o2) {
					Long a = o1[2];
					Long b = o2[2];
					return a.compareTo(b);
				}
			});
			root = new int [N];
			for (int j = 0; j < N; j++) {
				makeSet(j);
			}
			cnt = 0;
			for (int j = 0; j < list.size(); j++) {
				if(union((int)list.get(j)[0], (int)list.get(j)[1])) {
					result += list.get(j)[2];
					cnt++;
				}
				
				if(cnt == N-1) break;
				
			}
			sb.append("#").append(i+1).append(" ").append(Math.round(result*E)).append("\n");			
		}
		System.out.println(sb);
	}
	
	static void makeSet(int x) {
		root[x] = -1;
	}
	
	static int find(int k) {
		if(root[k] == -1) {
			return k;
		}else {
			return root[k] = find(root[k]);
		}
	}
	
	static boolean union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota != rootb) {
			root[roota] = rootb;
			return true;
		}
		return false;
	}
}
