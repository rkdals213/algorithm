package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14891_S1_톱니바퀴 {
	static int [][] map = new int [4][8]; // 0 : N, 1 : S
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp;
		for (int i = 0; i < 4; i++) {
			String ttt = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = ttt.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			temp = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(temp.nextToken())-1;
			int dir = Integer.parseInt(temp.nextToken()); // 1 : clock, 2: counter
			int dirtemp = dir;
			int [] samecheck = new int [4];
			
			for (int j = num-1; j >= 0; j--) {
				if(map[j][2] != map[j+1][6]) {
					samecheck[j] = 1;
				}else {
					break;
				}
			}
			for (int j = num+1; j < 4; j++) {
				if(map[j][6] != map[j-1][2]) {
					samecheck[j] = 1;
				}else {
					break;
				}
			}
			
			for (int j = num-1; j >= 0; j--) {
				dirtemp *= -1;
				if(samecheck[j] == 1) {
					if(dirtemp > 0) {
						clockwise(j);
					}else {
						counterclockwise(j);
					}
				}else {
					break;
				}
			}
			dirtemp = dir;
			for (int j = num+1; j < 4; j++) {
				dirtemp *= -1;
				if(samecheck[j] == 1) {
					if(dirtemp > 0) {
						clockwise(j);
					}else {
						counterclockwise(j);
					}
				}else {
					break;
				}
			}			
			
			if(dir > 0) {
				clockwise(num);
			}else {
				counterclockwise(num);
			}
			
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += map[i][0]*Math.pow(2, i);
		}
		System.out.println(sum);


	}

	static void clockwise(int k) {
		int t = map[k][7];
		for (int i = 7; i > 0; i--) {
			map[k][i] = map[k][i-1];
		}
		map[k][0] = t;

	}
	static void counterclockwise(int k) {
		int t = map[k][0];
		for (int i = 0; i < 7; i++) {
			map[k][i] = map[k][i+1];
		}
		map[k][7] = t;
	}

}
