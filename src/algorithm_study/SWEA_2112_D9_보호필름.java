package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_D9_보호필름 {
	static int D,W,K;
	static int [][] map;
	static int resultt = Integer.MAX_VALUE;
	static int time;
	static boolean [] visited; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			D = Integer.parseInt(temp.nextToken());
			W = Integer.parseInt(temp.nextToken());
			K = Integer.parseInt(temp.nextToken());
			map = new int [D][W];
			visited = new boolean [D];
			for (int i = 0; i < D; i++) {
				temp = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			time = 0;
			resultt = K;
			if(!check()) {
				chooseOne(0);
			}else {
				resultt = 0;
			}

			sb.append(resultt).append("\n");
		}
		System.out.println(sb);
	}

	static void chooseOne(int r) {
		if(time >= resultt) return;
		for (int i = r; i < D; i++) {
			if(!visited[i]) {
				visited[i] = true;
				time += 1;
				for (int j = 0; j < 2; j++) {
					int [] temp = new int [W];
					temp = change(i, j).clone(); // map 임시저장
					if(check()) {
						resultt = Math.min(time, resultt);
						visited[i] = false;
						time -= 1;
						map[i] = temp.clone(); // map 원복
						return;
					}
					chooseOne(i+1);
					map[i] = temp.clone(); // map 원복
				}
				visited[i] = false;
				time -= 1;
			}			
		}
	}

	static int [] change(int row, int kind) {
		int [] forRollBack = new int [W];
		for (int i = 0; i < W; i++) {
			forRollBack[i] = map[row][i];
			map[row][i] = kind;
		}
		return forRollBack;
	}

	static boolean check() {
		int res = 0;
		for (int j = 0; j < W; j++) {
			int now = 2;
			int cnt = 1;
			for (int i = 0; i < D; i++) {
				if(map[i][j] == now) {
					cnt++;
				}else {
					now = map[i][j];
					cnt = 1;
				}

				if(cnt >= K) {
					res++;
					break;
				}
			}
			if(res != j+1) return false;
		}
		return res == W;
	}
}
