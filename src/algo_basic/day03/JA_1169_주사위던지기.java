package algo_basic.day03;

import java.util.Arrays;
import java.util.Scanner;

public class JA_1169_주사위던지기 {
	// 주사위 배열
	static int [] dices;
	static int N;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 주사위 개수
		int M = scanner.nextInt();
		dices = new int [N]; // 출력 방식
		boolean [] visited = new boolean[6];
		switch(M) {
		case 1:
			// 첫번째 게임
			game1(0);
			break;
		case 2:		
			// 두번쨰 게임			
			game2(0, 1);
			break;
		case 3: 
			// 세번째 게임
			game3(0, visited);
			break;
		default:
			break;
		}

	}
	// 출력 함수
	public static void print() {
		for(int d:dices) {
			System.out.print(d + " ");
		}
		System.out.println();
	}
	// 게임 1
	public static void game1(int idx) {
		if(idx == N) {
			print();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			dices[idx] = i;
			game1(idx+1);
		}
	}
	// 게임 2
		public static void game2(int idx, int before) {
			if(idx == N) {
				print();
				return;
			}
			for (int i = before ; i <= 6; i++) {
				dices[idx] = i;
				game2(idx+1, i);
			}
		}
	// 게임 3
	public static void game3(int idx, boolean [] visited) {
		if(idx == N) {
			print();
			return;
		}
		for (int i = 1; i <= 6; i++) {
			if(!visited[i-1]) {
				dices[idx] = i;
				visited[i-1] = true;
				game3(idx+1, visited);
				visited[i-1] = false;
			}			
		}
	}
}
