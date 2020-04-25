package algo_ad.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2630_S3_색종이만들기 {
	static int [][] map;
	static int [] result = new int [2];
	static Queue<int [][]> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		StringTokenizer temp;
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		Papercheck(N, 0, 0);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}	

	}
	public static void Papercheck(int N, int x, int y) {

		if(!check(N,x,y)) {
			for(int i=x;i<x+N;i+=N/2) {
				for(int j=y;j<y+N;j+=N/2) {
					Papercheck(N/2,i,j);
				}
			}
		}else {
			result[map[x][y]]++;
		}			

	}
	public static boolean check(int N, int x, int y) {
		int k = map[x][y];
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j] != k) {
					return false;
				}				
			}
		}
		return true;
	}
}
