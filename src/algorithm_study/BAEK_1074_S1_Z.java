package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1074_S1_Z {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		int x  = Integer.parseInt(temp.nextToken());
		int y  = Integer.parseInt(temp.nextToken());
		int mapsize = (int) Math.pow(2, N);
		slicemap(mapsize, x, y, 0);
	}
	
	static void slicemap(int mapsize, int x, int y, int count) {
		int l = (int) Math.pow(2, mapsize-1);
		if(x>=l) count += Math.pow(4, mapsize-1)*2;
		if(y>=l) count += Math.pow(4, mapsize-1);
		if(x > 0 || y > 0) {
			slicemap(mapsize-1, x>=l?x-l:x, y>=l?y-l:y, count);
		}
		else {
			System.out.println(count);
			return;
		}
	}
}
