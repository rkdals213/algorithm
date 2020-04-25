package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1806_G3_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		int [] list = new int [N];
		int front = 0;
		int back = 0;
		int result = Integer.MAX_VALUE;
		
		temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < list.length; i++) {
			list[i] = Integer.parseInt(temp.nextToken());
		}
		int sum = list[0];
		while(true) {
			if(front < back) {
				front++;
				if(front == N) break;
				sum += list[front];
			}
			
			if(sum >= M) {
				result = Math.min(result, front-back+1);
				sum -= list[back];
				back++;
			}else {
				front++;
				if(front == N) break;
				sum += list[front];
			}
			
		}
		
		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);
	}

}
