package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_15683_G5_감시 {
	static int N,M;
	static int [][] map;
	static int [][] tempmap;
	static List<cctv> cctvList = new ArrayList<>();
	static int resultCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int [N][M];
		tempmap = new int [N][M];
		int wallCnt = 0;
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) cctvList.add(new cctv(i, j, map[i][j]));
				if(map[i][j] == 6) wallCnt++;
			}
		}
		if(cctvList.size() == 0) {
			System.out.println(N*M - wallCnt);
		}else {
			combi(0, new int[cctvList.size()], cctvList.size());
			System.out.println(resultCnt);
		}
	}

	static void combi(int r, int [] result, int cnt) {
		if(r == cnt) {
			//			System.out.println(Arrays.toString(result));
			for (int i = 0; i < N; i++) {
				tempmap[i] = map[i].clone();
			}
			for (int i = 0; i < cctvList.size(); i++) {
				int x = cctvList.get(i).x;
				int y = cctvList.get(i).y;
				int kind = cctvList.get(i).kind;
				switch (kind) {
				case 1:
					cctv1(x, y, result[i]);
					break;
				case 2:
					cctv2(x, y, result[i]);
					break;
				case 3:
					cctv3(x, y, result[i]);
					break;
				case 4:
					cctv4(x, y, result[i]);
					break;
				case 5:
					cctv5(x, y, result[i]);
					break;
				}
			}
			int emptyCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(tempmap[i][j] == 0) emptyCnt++;
				}
			}
			resultCnt = Math.min(resultCnt, emptyCnt);
		}else {
			for (int i = 0; i < 4; i++) {
				result[r] = i;
				combi(r+1, result, cnt);
			}
		}
	}
	// 우 하 좌 상
	static void cctv1(int x, int y, int dir) {
		switch (dir) {
		case 0:
			findR(x, y);
			break;
		case 1:
			findD(x, y);
			break;
		case 2:
			findL(x, y);
			break;
		case 3:
			findU(x, y);
			break;
		}
	}
	static void cctv2(int x, int y, int dir) {
		switch (dir) {
		case 0 | 2:
			findR(x, y);
			findL(x, y);
			break;
		case 1 | 3:
			findU(x, y);
			findD(x, y);
			break;
		}
	}
	static void cctv3(int x, int y, int dir) {
		switch (dir) {
		case 0:
			findU(x, y);
			findR(x, y);
			break;
		case 1:
			findR(x, y);
			findD(x, y);
			break;
		case 2:
			findD(x, y);
			findL(x, y);
			break;
		case 3:
			findL(x, y);
			findU(x, y);
			break;
		}
	}
	static void cctv4(int x, int y, int dir) {
		switch (dir) {
		case 0:
			findD(x, y);
			findL(x, y);
			findU(x, y);
			break;
		case 1:
			findD(x, y);
			findL(x, y);
			findR(x, y);
			break;
		case 2:
			findD(x, y);
			findU(x, y);
			findR(x, y);
			break;
		case 3:
			findL(x, y);
			findU(x, y);
			findR(x, y);
			break;
		}
	}
	static void cctv5(int x, int y, int dir) {
		findD(x, y);
		findL(x, y);
		findU(x, y);
		findR(x, y);
	}

	static void findR(int x, int y) {
		for (int i = y; i < M; i++) {
			if(map[x][i] == 6) break;
			tempmap[x][i] = -1;
		}
	}
	static void findD(int x, int y) {
		for (int i = x; i < N; i++) {
			if(map[i][y] == 6) break;
			tempmap[i][y] = -1;
		}
	}
	static void findL(int x, int y) {
		for (int i = y; i >= 0; i--) {
			if(map[x][i] == 6) break;
			tempmap[x][i] = -1;
		}
	}
	static void findU(int x, int y) {
		for (int i = x; i >= 0; i--) {
			if(map[i][y] == 6) break;
			tempmap[i][y] = -1;
		}
	}
	static class cctv{
		int x,y,kind;

		public cctv(int x, int y, int kind) {
			super();
			this.x = x;
			this.y = y;
			this.kind = kind;
		}

		@Override
		public String toString() {
			return "cctv [x=" + x + ", y=" + y + ", kind=" + kind + "]";
		}
	}
}
