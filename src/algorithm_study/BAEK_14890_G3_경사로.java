package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14890_G3_경사로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int L = Integer.parseInt(temp.nextToken());
		int [][] map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int front = 1;
			int back = 0;
			boolean f = true;
			outer:
			for (int j = 1; j < N; j++) {
				front = j;
				if(map[i][j] == map[i][j-1]) {
					
				}else if(map[i][j] == map[i][j-1] + 1) {
					if(front - back < L) {						
						f = false;
						break outer;
					}else {
						back = front;
					}
				}else if(map[i][j] == map[i][j-1] - 1){
					back = front;
					for (int k = j+1; k < j+L; k++) {
						if(k >= N) {
							f = false;
							break outer;
						}	
						if(map[i][j] == map[i][k]) {
							front++;
						}else {
							f = false;
							break outer;
						}
					}
					j = front;
					back = ++front;
				}else {
					f = false;
					break;
				}
			}
			if(f) result++;
		}
		
		
		for (int j = 0; j < N; j++) {
			int front = 1;
			int back = 0;
			boolean f = true;
			outer:
			for (int i = 1; i < N; i++) {
				front = i;
				if(map[i][j] == map[i-1][j]) {
					
				}else if(map[i][j] == map[i-1][j] + 1) {
					if(front - back < L) {						
						f = false;
						break outer;
					}else {
						back = front;
					}
				}else if(map[i][j] == map[i-1][j] - 1){
					back = front;
					for (int k = i+1; k < i+L; k++) {
						if(k >= N) {
							f = false;
							break outer;
						}						
						if(map[i][j] == map[k][j]) {
							front++;
						}else {
							f = false;
							break outer;
						}
					}
					i = front;
					back = ++front;
				}else {
					f = false;
					break;
				}
			}
			if(f) result++;
		}
		
		
		System.out.println(result);
	}
}
