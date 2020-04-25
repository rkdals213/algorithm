package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17136_G3_색종이붙이기 {
	static int [] papersize = {1,2,3,4,5};
	static int count = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp;
		int [] paper = {5,5,5,5,5}; // 색종이의 종류별 갯수를 저장하는 배열
		int [][] map = new int [10][10]; 

		for (int i = 0; i < 10; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		DFS(paper, map, 0, 0);
		if(count == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
		

	}

	static void DFS(int [] paper, int map [][], int c, int x) {	
		/* 현재 색종이의 갯수, map, 색종이를 붙인 횟수,
		 x 시작 좌표(연산을 빠르게 하기 위함 : 위쪽 왼족부터 오른쪽으로 탐색을 진행하므로 색종이를 붙인 위치의 이전 위치들은 탐색할 필요가 없음)*/
		if(c > count)return; // 백트랙킹 구간으로 색종이를 붙인 횟수가 현재 색종이를 붙인 최솟값을 넘어서면 이후는 진행할 필요가 없음
		boolean flag = false;
		outer : for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) { // 만약 1이 남아있다면 재귀를 계속 돌려야 하므로 flag를 true로 바꿈
					flag = true;
					break outer;
				}
			}		
		}
		if(!flag) { // map에 1값이 하나도 없다면 색종이를 모두 붙인것 이므로 
			count = Math.min(count, c); // 현재까지 붙인 색종이 개수를 min값과 비교하여 갱신함
			return; // 재귀 종료
		}
		for (int i = x; i < 10; i++) { // x,0부터 탐색을 시작하여
			for (int j = 0; j < 10; j++) {
				if(map[i][j] == 1) { // 최초의 1이 발견되면
					for (int k = 4; k >= 0; k--) { // 색종이가 큰것부터 차례로 붙여보며
						if(paperOK(i,j,map,papersize[k])) { // 색종이를 붙였을때 조건에 맞다면(색종이가 범위 안에 있고 0값을 덮지 않아야함)
							if(paper[k]-1 >= 0) { // 붙일 색종이의 갯수가 남아있을경우
								map = change(i, j, map, papersize[k], 0); // 색종이를 붙이고
								paper[k]--; // 붙인 색종이의 개수를 감소시킨다음
								DFS(paper, map, c+1, i); // 붙인 색종이 갯수를 1추가하여 재귀 호출하며 
								map = change(i, j, map, papersize[k], 1); // 재귀가 끝나면 붙인 색종이를 떼고 
								paper[k]++; // 붙인 색종이의 개수를 증가시켜 다음 색종이를 붙여서 테스트 할수 있게 초기화 시킨다
							}						
						}
					}	
					return; // 최초의 1에 모든 색종이를 다 붙여보게 되면 그 다음 1들은 재귀를 통해 해결 되므로 
					// 더이상 탐색을 할 필요가 없게 된다 -> return
				}
			}
		}
	}
	
	static int [][] change(int x, int y, int [][] map, int size, int c){ // 색종이를 떼고 붙이는 함수
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				map[i][j] = c;
			}
		}
		return map;
	}
	
	static boolean paperOK(int x, int y, int [][] map, int size) { // 색종이가 조건에 맞게 붙여지는지 체크하는 함수
		if(isIn(x+size-1, y+size-1)) {
			for (int i = x; i < x+size; i++) {
				for (int j = y; j < y+size; j++) {
					if(map[i][j] == 0) {
						return false;
					}
				}
			}
		}else {
			return false;
		}
		return true;
	}

	static boolean isIn(int x, int y) {
		return x < 10 && y < 10;
	}
}
