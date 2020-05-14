package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5643_D4_키순서 {
	static int N,M;
	static int [][] bigOrsmall;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			bigOrsmall = new int [N][N];
			for (int i = 0; i < M; i++) {
				StringTokenizer temp = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(temp.nextToken())-1;
				int b = Integer.parseInt(temp.nextToken())-1;
				bigOrsmall[a][b] = 1;
				bigOrsmall[b][a] = -1;
				
				search(a, b);
			}
			int cnt = N;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(bigOrsmall[i][j] == 0) {
						if(i==j) continue;
						else {
							cnt--;
							break;
						}
					}					
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void search(int a, int b) {
		for (int i = 0; i < N; i++) {
			if(bigOrsmall[a][i] == -1 && bigOrsmall[i][b] == 0) {
				bigOrsmall[i][b] = 1;
				bigOrsmall[b][i] = -1;
				search(i, b);
			}
		}
		for (int i = 0; i < N; i++) {
			if(bigOrsmall[b][i] == 1 && bigOrsmall[i][a] == 0) {
				bigOrsmall[i][a] = -1;
				bigOrsmall[a][i] = 1;
				search(i, a);
			}
		}
	}

}
