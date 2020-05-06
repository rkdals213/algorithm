package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_6987_S3_월드컵 {
	static boolean [] visited = new boolean [6];
	static int [] team1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int [] team2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int [][] dboard1 = new int [6][3];
	static int [][] dboard2 = new int [6][3];
	static int [] result = new int [4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			StringTokenizer	temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					dboard1[j][k] = Integer.parseInt(temp.nextToken());
				}				
			}		
			DFS(i, 0);			
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
	
	static void DFS(int tc, int depth) {
		if(depth == 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if(dboard1[i][j] != dboard2[i][j]) return;
				}
			}
			result[tc] = 1;
			return;
		}else {
			int t1 = team1[depth];
			int t2 = team2[depth];
			for (int i = 0; i < 3; i++) {
				dboard2[t1][i]++;
				dboard2[t2][2-i]++;
				DFS(tc, depth+1);
				dboard2[t1][i]--;
				dboard2[t2][2-i]--;
			}	
		}
	}

}
