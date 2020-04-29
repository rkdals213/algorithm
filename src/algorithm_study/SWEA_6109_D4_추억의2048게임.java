package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6109_D4_추억의2048게임 {
	static int N;
	static int dir;
	static int [][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());		
		
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append("\n");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			String d = temp.nextToken();
			if(d.equals("up")) dir = 0;
			if(d.equals("right")) dir = 1;
			if(d.equals("down")) dir = 2;
			if(d.equals("left")) dir = 3;
			
			map = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				temp = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			
			add();
			move();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void add() {
		if(dir==0) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N-1; i++) {
					if(map[i][j] != 0) {
						for (int k = i+1; k < N; k++) {
							if(map[k][j] != 0) {
								if(map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		if(dir==1) {
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j > 0; j--) {
					if(map[i][j] != 0) {
						for (int k = j-1; k >= 0; k--) {
							if(map[i][k] != 0) {
								if(map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		if(dir==2) {
			for (int j = 0; j < N; j++) {
				for (int i = N-1; i > 0; i--) {
					if(map[i][j] != 0) {
						for (int k = i-1; k >= 0; k--) {
							if(map[k][j] != 0) {
								if(map[i][j] == map[k][j]) {
									map[i][j] *= 2;
									map[k][j] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
		if(dir==3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-1; j++) {
					if(map[i][j] != 0) {
						for (int k = j+1; k < N; k++) {
							if(map[i][k] != 0) {
								if(map[i][j] == map[i][k]) {
									map[i][j] *= 2;
									map[i][k] = 0;
								}
								break;
							}
						}
					}
				}
			}
		}
	}
	
	static void move() {
		if(dir==0) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N-1; i++) {
					if(map[i][j] == 0) {
						for (int k = i+1; k < N; k++) {
							if(map[k][j] != 0) {
								map[i][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}
				}
			}
		}
		if(dir==1) {
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j > 0; j--) {
					if(map[i][j] == 0) {
						for (int k = j-1; k >= 0; k--) {
							if(map[i][k] != 0) {
								map[i][j] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}
		if(dir==2) {
			for (int j = 0; j < N; j++) {
				for (int i = N-1; i > 0; i--) {
					if(map[i][j] == 0) {
						for (int k = i-1; k >= 0; k--) {
							if(map[k][j] != 0) {
								map[i][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}
				}
			}
		}
		if(dir==3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N-1; j++) {
					if(map[i][j] == 0) {
						for (int k = j+1; k < N; k++) {
							if(map[i][k] != 0) {
								map[i][j] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}
	}
	
}
