package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_17779_G4_게리맨더링2 {
	static int N;
	static int [][] map;
	static int [][] dir4 = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean [][] visited;
	static int [] score;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		int total = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
				total += map[i][j];
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				for (int d1 = 1; i+d1<N && j-d1>=0; d1++) {
					for (int d2 = 1; i+d2<N && j+d2<N && i+d1+d2<N; d2++) {					
						score = new int [5];
						
						for (int a = 0; a < i; a++) {
							for (int b = 0; b <= j; b++) {
								score[0] += map[a][b];
							}
						}
						int cnt = 1;
						for (int a = i; a < i+d1; a++) {
							for (int b = 0; b <= j-cnt; b++) {
								score[0] += map[a][b];								
							}
							cnt++;
						}
						////////////////////////
						for (int a = 0; a <= i; a++) {
							for (int b = j+1; b < N; b++) {
								score[1] += map[a][b];
							}
						}
						cnt = 1;
						for (int a = i+1; a <= i+d2; a++) {
							for (int b = j+cnt+1; b < N; b++) {
								score[1] += map[a][b];								
							}
							cnt++;
						}
						/////////////////////////
						for (int a = i+d1+d2+1; a < N; a++) {
							for (int b = j+d2-d1; b < N; b++) {
								score[2] += map[a][b];
							}
						}
						cnt = 1;
						for (int a = i+d1+d2; a > i+d2; a--) {
							for (int b = j+d2-d1+cnt; b < N; b++) {
								score[2] += map[a][b];								
							}
							cnt++;
						}
						//////////////////////////
						for (int a = i+d1+d2; a < N; a++) {
							for (int b = 0; b < j+d2-d1; b++) {
								score[3] += map[a][b];
							}
						}
						cnt = 1;
						for (int a = i+d1+d2-1; a >= i+d1; a--) {
							for (int b = 0; b <= j+d2-d1-cnt-1; b++) {
								score[3] += map[a][b];
							}
							cnt++;
						}					
					
						score[4] = total - score[0] - score[1] - score[2] - score[3];
						Arrays.sort(score);
						int min = score[4]- score[0];
						result = Math.min(result, min);
					}
				}
				
			}
		}
		System.out.println(result);
		
	}	
}
