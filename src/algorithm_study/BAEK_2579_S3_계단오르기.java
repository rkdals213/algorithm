package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_2579_S3_계단오르기 {
    static int [] stairs;
	static int [] point;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stairs = new int [N+1];
		point = new int [N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		if(N >= 3) {
			point[1] = stairs[1];
			point[2] = point[1] + stairs[2];
			point[3] = Math.max(stairs[1]+stairs[3], stairs[2]+stairs[3]);
			for (int i = 4; i <= N; i++) {
				point[i] = Math.max(point[i-3] + stairs[i-1], point[i-2]) + stairs[i];
			}
		}else if(N==2) {
			point[2] = stairs[1] + stairs[2];
		}else if(N==1){
			point[1] = stairs[1];;
		}
		
		System.out.println(point[N]);
		
	}

}
