package algo_ad.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_11728_S5_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		int [] arr1 = new int [N];
		int [] arr2 = new int [M];

		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(temp.nextToken());
		}

		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr2[i] = Integer.parseInt(temp.nextToken());
		}
		int a1 = 0;
		int a2 = 0;

		while(a1 < N && a2 < M) {
			if(arr1[a1] <= arr2[a2]) {
				sb.append(arr1[a1]).append(" ");
				a1++;
			}else {
				sb.append(arr2[a2]).append(" ");
				a2++;
			}
		}
		while(a1 < N) {			
			sb.append(arr1[a1]).append(" ");
			a1++;
		}
		while(a2 < M) {
			sb.append(arr2[a2]).append(" ");
			a2++;
		}

		System.out.println(sb);
	}
}
