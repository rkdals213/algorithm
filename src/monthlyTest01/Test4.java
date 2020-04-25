package monthlyTest01;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Test4 {
	static int N, Si, Sj, P, D;
	static int Answer;
	static int [][] dir = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Test4.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int step = 0;
			N = sc.nextInt();
			Si = sc.nextInt()-1; // 출발점의 i좌표
			Sj = sc.nextInt()-1; // 출발점의 j좌표
			P = sc.nextInt(); // 함정의 개수

			int Pi[] = new int[P]; // 함정의 i좌표의 모음
			int Pj[] = new int[P]; // 함정의 j좌표의 모음

			for (int k = 0; k < P; k++) { // 함정 좌표 읽어서 저장
				Pi[k] = sc.nextInt()-1;
				Pj[k] = sc.nextInt()-1;
			}

			D = sc.nextInt();
			int Dd[] = new int[D]; // 방향 모음
			int Da[] = new int[D]; // 이동 칸수 모음

			for (int k = 0; k < D; k++) { // 방향, 이동칸수 읽어서 저장
				Dd[k] = sc.nextInt()-1;
				Da[k] = sc.nextInt();
			}
			//////////////////////////////
			// ( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			boolean [][] map = new boolean [N][N];
			for (int i = 0; i < P; i++) {
				map[Pi[i]][Pj[i]] = true;
			}
			int x = Si;
			int y = Sj;
			for (int i = 0; i < Da.length; i++) {
				
				for (int j = 0; j < Da[i]; j++) {
					x += dir[Dd[i]][0];
					y += dir[Dd[i]][1];
					
					if(isIn(x, y, map) && !map[x][y]) {						
						step ++;
					}else {
						break;
					}
				}
				if(!isIn(x, y, map) || map[x][y]) {
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + step);
		}
	}
	public static boolean isIn(int x, int y, boolean [][] map) {
		return x>=0 && y>=00 && x<map.length && y<map.length;
	}
}