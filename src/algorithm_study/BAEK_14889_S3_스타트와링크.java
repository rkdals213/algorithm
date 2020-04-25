package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_14889_S3_스타트와링크 {
    static int N;
	static int[][] person;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		person = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				person[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		comb(0, N/2, new boolean [N], 0);
		System.out.println(result);
	}
	
	static void comb(int r, int depth, boolean [] result, int start) {
		if(r == depth) {
//			System.out.println(Arrays.toString(result));
			calculate(result);
		}else {
			for (int i = start; i < N; i++) {
				result[i] = true;
				comb(r+1, depth, result, i+1);
				result[i] = false;
			}
		}
	}
	
	static void calculate(boolean [] rt) {
		int start = 0;
		int link = 0;
		int [] startM = new int [N/2]; 
		int [] linkM = new int [N/2]; 
		for (int i = 0; i < N; i++) {
			if(rt[i]) {
				startM[start] = i;
				start++;
			}else {
				linkM[link] = i;
				link++;
			}
		}
//		System.out.println(Arrays.toString(startM) + " : " + Arrays.toString(linkM));
		
		int startPoint = 0;
		int linkPoint = 0;
		
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(i!=j) {
					startPoint += person[startM[i]][startM[j]];
					linkPoint += person[linkM[i]][linkM[j]];
				}
			}
		}
		
		int resultPoint = Math.abs(startPoint-linkPoint);
		result = Math.min(resultPoint, result);
		
	}

}
