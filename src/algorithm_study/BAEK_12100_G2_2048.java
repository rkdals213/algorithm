package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_12100_G2_2048 {
	static int N;
	static int[][] map;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		for (int i = 0; i < 4; i++) {
			DFS(0, new int [5], i);
		}
		
		System.out.println(result);

	}

	static void DFS(int r, int [] result, int dir) {
		if(r == 5) {
			add(result);
		}else {
			for (int i = 0; i < 4; i++) {
				result[r] = i;
				DFS(r+1, result, i);
			}
		}
	}

	static void add(int [] moving) { // 0 : 상, 1 : 우, 2 : 좌, 3 : 하
		int [][] mapcopy = new int [N][N];
		for (int i = 0; i < N; i++) {
			mapcopy[i] = map[i].clone();
		}
		for (int i = 0; i < moving.length; i++) {
			if(moving[i] == 0) {
				for (int k = 0; k < N; k++) {
					for (int j = 0; j < N; j++) {
						for (int j2 = j+1; j2 < N; j2++) {							
							if(mapcopy[j][k] == mapcopy[j2][k]) {
								mapcopy[j][k] *= 2;
								mapcopy[j2][k] = 0;	
								break;
							}else if(mapcopy[j][k] != mapcopy[j2][k] && mapcopy[j2][k] != 0) {
								break;
							}
						}
					}
				}
			}else if(moving[i] == 1) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						for (int k2 = k+1; k2 < N; k2++) {
							if(mapcopy[j][k] == mapcopy[j][k2]) {
								mapcopy[j][k] *= 2;
								mapcopy[j][k2] = 0;
								break;
							}else if(mapcopy[j][k] != mapcopy[j][k2] && mapcopy[j][k2] != 0) {
								break;
							}
						}
					}
				}
			}else if(moving[i] == 2) {
				for (int j = 0; j < N; j++) {
					for (int k = N-1; k > 0; k--) {
						for (int k2 = k-1; k2 >= 0; k2--) {
							if(mapcopy[j][k] == mapcopy[j][k2]) {
								mapcopy[j][k] *= 2;
								mapcopy[j][k2] = 0;
								break;
							}else if(mapcopy[j][k] != mapcopy[j][k2] && mapcopy[j][k2] != 0) {
								break;
							}
						}
					}
				}
			}else if(moving[i] == 3) {
				for (int k = 0; k < N; k++) {
					for (int j = N-1; j > 0; j--) {
						for (int j2 = j-1; j2 >= 0; j2--) {
							if(mapcopy[j][k] == mapcopy[j2][k]) {
								mapcopy[j][k] *= 2;
								mapcopy[j2][k] = 0;
								break;
							}else if(mapcopy[j][k] != mapcopy[j2][k] && mapcopy[j2][k] != 0) {
								break;
							}
						}
					}
				}
			}
			move(moving[i], mapcopy);
		}
	}

	static void move(int d, int [][] mapcopy) {
		if(d == 0) {
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++) {
					for (int j2 = j+1; j2 < N; j2++) {
						if(mapcopy[j][k] == 0 && mapcopy[j2][k] != 0) {
							mapcopy[j][k] = mapcopy[j2][k];
							mapcopy[j2][k] = 0;
						}
					}
				}
			}
		}else if(d == 1) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int k2 = k+1; k2 < N; k2++) {
						if(mapcopy[j][k] == 0 && mapcopy[j][k2] != 0) {
							mapcopy[j][k] = mapcopy[j][k2];
							mapcopy[j][k2] = 0;
						}
					}
				}
			}
		}else if(d == 2) {
			for (int j = 0; j < N; j++) {
				for (int k = N-1; k > 0; k--) {
					for (int k2 = k-1; k2 >= 0; k2--) {
						if(mapcopy[j][k] == 0 && mapcopy[j][k2] != 0) {
							mapcopy[j][k] = mapcopy[j][k2];
							mapcopy[j][k2] = 0;
						}
					}
				}
			}
		}else if(d == 3) {
			for (int k = 0; k < N; k++) {
				for (int j = N-1; j > 0; j--) {
					for (int j2 = j-1; j2 >= 0; j2--) {
						if(mapcopy[j][k] == 0 && mapcopy[j2][k] != 0) {
							mapcopy[j][k] = mapcopy[j2][k];
							mapcopy[j2][k] = 0;
						}
					}
				}
			}
		}
		findmax(mapcopy);
	}

	static void findmax(int [][] mapcopy) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp = Math.max(temp, mapcopy[i][j]);
			}
		}
		result = Math.max(result, temp);
	}

}
